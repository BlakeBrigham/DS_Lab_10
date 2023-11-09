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
	   this.val = val;
	   this.left = l;
	   this.right = r;
   }



   /*
     Uses recursion to insert the target into the tree
     
     Add a node to the tree
    */
   public void insert(T target)
   {
	   if (this.val.compareTo(target) > 0)
	   {
		   if (this.left == null)
		   {
			   this.left = new BSTNode<>(target, null, null);
		   }
		   else
		   {
			   this.left.insert(target);
		   }
	   }
	   else
	   {
		   if (this.right == null)
		   {
			   this.right = new BSTNode<>(target, null, null);
		   }
		   else
		   {
			   this.right.insert(target);
		   }
	   }
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
     
     NOT POP, need to go through whole tree
    */
   public T retrieve(T target)
   {
	   if (this.val.compareTo(target) > 0) // go left
	   {
		   if (this.left == null)
		   {
			   return null;
		   }
		   else
		   {
			   return this.left.retrieve(target);
		   }
	   }
	   else if (this.val.compareTo(target) < 0) // go right
	   {
		   if (this.right == null)
		   {
			   return null;
		   }
		   else
		   {
			   return this.right.retrieve(target);
		   }
	   }
	   else // found target
	   {
		   return target;
	   }
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
       
       Have to go down the whole tree and keep track of farthest depth reached
     */
   public int retrieveDepth(T target)
   {
	   if (this.val.compareTo(target) > 0) // go left
	   {
		   if (this.left == null)
		   {
			   return 1;
		   }
		   else
		   {
			   return this.left.retrieveDepth(target) + 1;
		   }
	   }
	   else if (this.val.compareTo(target) < 0) // go right
	   {
		   if (this.right == null)
		   {
			   return 1;
		   }
		   else
		   {
			   return this.right.retrieveDepth(target) + 1;
		   }
	   }
	   else // this.val == target
	   {
		   return 0;
	   }
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
	if (this.right == null)
	{
		return this.val;
	}
	else 
	{
		return this.right.getLargest();
	}
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {
	   // Left
	   if (this.left != null)
	   {
		   this.left.inOrderTraversal(consume);
	   }
	   // View
	   consume.accept(this.val);
	   // Right
	   if (this.right != null)
	   {
		   this.right.inOrderTraversal(consume);
	   }
	   
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While "this" must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
	   if (this.val == that.val)
	   {
		   boolean leftEquals = false;
		   boolean rightEquals = false;
		   if (this.left != null && that.left != null)
		   {
			   leftEquals = this.left.myEquals(that.left);
		   }
		   else if (this.left == null && that.left == null)
		   {
			   leftEquals = true;
		   }
		   
		   if (this.right != null && that.right != null)
		   {
			   rightEquals = this.right.myEquals(that.right);
		   }
		   else if (this.right == null && that.right == null)
		   {
			   rightEquals = true;
		   }
		   
		   return leftEquals && rightEquals;
	   }
	   return false;
   

   }

}
