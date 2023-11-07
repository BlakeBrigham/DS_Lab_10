import java.lang.Comparable;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;



   public BSTNode(T val)
   {
      this(val,null,null);
   }
    

   public BSTNode(T val, BSTNode<T> l,BSTNode<T> r)
   {
   }



   /*
     Uses recursion to insert the target into the tree
     
     Add a node to the tree
    */
   public void insert(T target)
   {
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
     
     NOT POP, need to go through whole tree
    */
   public T retrieve(T target)
   {
	return target;
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
       
       Have to go down the whole tree and keep track of farthest depth reached
     */
   public int retrieveDepth(T target)
   {
	return 0;
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
	return null;
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {

   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
	return false;
   

   }

}
