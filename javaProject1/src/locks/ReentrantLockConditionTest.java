/**************************************************************************************************
 *  ____  _  _  ____  _____  ____  __  __    __   ____  ____  ___    __   
 * (_  _)( \( )( ___)(  _  )(  _ \(  \/  )  /__\ (_  _)(_  _)/ __)  /__\  
 *  _)(_  )  (  )__)  )(_)(  )   / )    (  /(__)\  )(   _)(_( (__  /(__)\ 
 * (____)(_)\_)(__)  (_____)(_)\_)(_/\/\_)(__)(__)(__) (____)\___)(__)(__) 
 * 
 * Informatica PIM
 *
 * copyright: Informatica Corp. (c) 2003-2013.  All rights reserved.
 * 
 *************************************************************************************************/

package locks;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kulshres
 */
public class ReentrantLockConditionTest
{
  public static void main( String[] args )
  {

    List< Integer > sharedQueue = new LinkedList< Integer >(); //Creating shared object

    Lock lock = new ReentrantLock();
    //producerCondition
    Condition producerCondition = lock.newCondition();
    //consumerCondition
    Condition consumerCondition = lock.newCondition();

    Producer producer = new Producer( sharedQueue, lock, producerCondition, consumerCondition );
    Consumer consumer = new Consumer( sharedQueue, lock, producerCondition, consumerCondition );

    Thread producerThread = new Thread( producer, "ProducerThread" );
    Thread consumerThread = new Thread( consumer, "ConsumerThread" );
    producerThread.start();
    consumerThread.start();

  }
}

/**
 * Producer Class.
 */
class Producer implements Runnable
{

  private List< Integer > sharedQueue;
  private int             maxSize = 2;      //maximum number of products which sharedQueue can hold at a time.

  Lock                    lock;
  Condition               producerCondition;
  Condition               consumerCondition;

  public Producer( List< Integer > sharedQueue, Lock lock, Condition producerCondition, Condition consumerCondition )
  {
    this.sharedQueue = sharedQueue;
    this.lock = lock;
    this.producerCondition = producerCondition;
    this.consumerCondition = consumerCondition;
  }

  @Override
  public void run()
  {
    for ( int i = 1; i <= 10; i++ )
    { //produce 10 products.
      try
      {
        produce( i );
      }
      catch ( InterruptedException e )
      {
        e.printStackTrace();
      }
    }
  }

  public void produce( int i ) throws InterruptedException
  {
    this.lock.lock();

    // if sharedQuey is full producer await until consumer consumes.
    if ( this.sharedQueue.size() == this.maxSize )
    {
      this.producerCondition.await();
    }

    System.out.println( "Produced : " + i );
    // as soon as producer produces (by adding in sharedQueue) it signals consumer.
    this.sharedQueue.add( i );
    this.consumerCondition.signal();

    this.lock.unlock();

  }

}

/**
 * Consumer Class.
 */
class Consumer implements Runnable
{
  private List< Integer > sharedQueue;
  Lock                    lock;
  Condition               producerCondition;
  Condition               consumerCondition;

  public Consumer( List< Integer > sharedQueue, Lock lock, Condition producerCondition, Condition consumerCondition )
  {
    this.sharedQueue = sharedQueue;
    this.lock = lock;
    this.producerCondition = producerCondition;
    this.consumerCondition = consumerCondition;
  }

  @Override
  public void run()
  {
    for ( int i = 1; i <= 10; i++ )
    { //produce 10 products.
      try
      {
        consume();
      }
      catch ( InterruptedException e )
      {
        e.printStackTrace();
      }
    }

  }

  public void consume() throws InterruptedException
  {
    this.lock.lock();

    // if sharedQuey is empty consumer await until producer produces.
    if ( this.sharedQueue.size() == 0 )
    {
      this.consumerCondition.await();
    }

    /*If sharedQueue not empty consumer will consume
    * (by removing from sharedQueue) and signal the producer.
    */
    System.out.println( "CONSUMED: " + this.sharedQueue.remove( 0 ) );
    this.producerCondition.signal();

    this.lock.unlock();

  }

}
