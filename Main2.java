import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*   
Class: Data Structures & Algorithms           */

public class Main2 {

	public static void main(String[] arg)
    {
		
		// Running code
		 
		System.out.println("Testing code with small numbers");
		System.out.println();
		
		//Testing Heap with small values
		System.out.println("Sorted Heap ");
        System.out.println("The Max Heap is ");

        Heap heap = new Heap(15);
 
        // Inserting nodes
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);
 
        // Showing heap
        heap.print();
 
        // Print and display the maximum value in heap
        System.out.println("The max val is "
                           + heap.extractMax());
        
        //Testing unsorted PQ with small values
        ArrayList<Integer> array = new ArrayList<Integer>();
	    int size = array.size();

	    PriorityQ  pq = new PriorityQ ();
	    pq.insert(array, 45);
	    pq.insert(array, 31);
	    pq.insert(array, 14);
	    pq.insert(array, 13);
	    pq.insert(array, 20);
	    pq.insert(array, 7);
	    pq.insert(array, 11);
	    pq.insert(array, 12);
	    pq.insert(array, 7);

	    System.out.println();
	    System.out.println("Unsorted PQ: ");
	    pq.printArray(array, size);

	    pq.deleteNode(array, 45);
	    System.out.println();
	    System.out.println("After deleting an element: ");
	    pq.printArray(array, size);
	    
	    //Testing insertion sort
	    System.out.println();
	    System.out.println("Testing insertion sort");
	    pq.insertionSort(array);
	    pq.printArray(array, size);
	    
	    System.out.println();
	    System.out.println("Inserting new elements");
	    pq.insert(array, 11);
	    pq.insert(array, 12);
	    pq.insert(array, 7);
	    System.out.println("Unsorted PQ: ");
	    pq.printArray(array, size);
	
	    //Testing selection sort
	    System.out.println();
	    System.out.println("Testing selection sort");
	    pq.selectionSort(array);
	    pq.printArray(array, size);
	  
	    //Testing sorted PQ with small values
        ArrayList<Integer> array1 = new ArrayList<Integer>();
	    int size1 = array1.size();

	    SortPriorityQ  pq1 = new SortPriorityQ();
	    pq1.insert(array1, 45);
	    pq1.insert(array1, 31);
	    pq1.insert(array1, 14);
	    pq1.insert(array1, 13);
	    pq1.insert(array1, 20);
	    pq1.insert(array1, 7);
	    pq1.insert(array1, 11);
	    pq1.insert(array1, 12);
	    pq1.insert(array1, 7);
	    System.out.println();
	    System.out.println("Sorted PQ:");
	    pq1.printArray(array1, size1);
	    
	    
	    //Running code with 100 random values
	    System.out.println();
	    System.out.println("Testing code with 100 random numbers using PQ unsorted");
	    
	    Random rd = new Random(); // creating Random object
	    int pick;
	    ArrayList<Integer> arrayt =  new ArrayList<Integer>();
	    PriorityQ  pq2 = new PriorityQ ();//creating priority q with 100 random values
	    int size2 = arrayt.size();
	    
        for (int j = 0; j<101; j++)
        {
            pick = rd.nextInt(100);
            pq2.insert(arrayt,pick);//storing random values
 
        }

        System.out.println();
	    System.out.println("Unsorted PQ: ");
	    pq2.printArray(arrayt, size2);
	    
	    //Testing insertion sort
	    System.out.println();
	    System.out.println("Testing insertion sort");
       
	    //Timing
	    double startTime = System.nanoTime();
	    pq2.insertionSort(arrayt);
	    long endTime = System.nanoTime();
	    long duration = (long) ((endTime - startTime)/1000000); //divide by 1000000 to get miliseconds
	   
	    pq2.printArray(arrayt, size2);
	    System.out.println();
	    System.out.println("Duration:");
	    System.out.println(duration);

	  //Running code with 100 random values for selection sort
	    System.out.println();
	    System.out.println("Testing code with 100 random numbers using PQ unsorted");
	    
	    Random rd1 = new Random(); // creating Random object
	    int pick1;
	    ArrayList<Integer> arrayt1 =  new ArrayList<Integer>();
	    PriorityQ  pq3 = new PriorityQ ();//creating priority q with 100 random values
	    int size3 = arrayt.size();
	    
        for (int j = 0; j<101; j++)
        {
            pick1 = rd1.nextInt(100);
            pq3.insert(arrayt1,pick1);//storing random values
 
        }

        System.out.println();
	    System.out.println("Unsorted PQ: ");
	    pq3.printArray(arrayt1, size3);
	    
	    //Testing insertion sort
	    System.out.println();
	    System.out.println("Testing selection sort");
       
	    //5) Timing
	    double startTime1 = System.nanoTime();
	    pq3.insertionSort(arrayt1);
	    long endTime1 = System.nanoTime();
	    long duration1 = (long) ((endTime1 - startTime1)/1000000); //divide by 1000000 to get miliseconds
	   
	    pq3.printArray(arrayt1, size3);
	    System.out.println();
	    System.out.println("Duration:");
	    System.out.println(duration1);
		 
	    
    }//end of main method

}//end of main class

 //Heap Class 
//Max heap
 class Heap {
    private int[] dataOfHeap;
    private int size;
    private int maxSize;
 
    /**
     * Initializing a heap with a maximum size
     * @param maxsize
     */
    public Heap(int maxSize)
    {
        
        this.maxSize = maxSize;
        this.size = 0;
        dataOfHeap = new int[this.maxSize];
    }
 
    /**
     * To return parent position
     * @param position
     * @return
     */
    public int parent(int position) { return (position - 1) / 2; }
 
    /**
     * To return left children position
     * @param pos
     * @return
     */
    public int leftChild(int position) { return (2 * position); }
 
    /**
	 * 	To return right children position
	 * @param pos
	 * @return
	 */
    public int rightChild(int position)
    {
        return (2 * position) + 1;
    }
 
    /**
     * To check if the node is leaf or not
     * @param position
     * @return true if node is leaf and false otherwise
     */
    private boolean isLeaf(int position)
    {
        if (position > (size / 2) && position <= size) {
            return true;
        }
        return false;
    }
 
    /**
     * It will swap given nodes
     * @param firtNodePos
     * @param secondNodepos
     */
    private void swapNodes(int fposition, int sposition)
    {
        int temporary;
        temporary = dataOfHeap[fposition];
        dataOfHeap[fposition] = dataOfHeap[sposition];
        dataOfHeap[sposition] = temporary;
    }
 
    /**
     * Heap Sort: Method that heapify given node 
     * @param position
     */
    private void heapify(int position)
    {
    	//checking if the node is a leaf 
        if (isLeaf(position))
            return;
 
        //checking left or right child are greater than given node
        if (dataOfHeap[position] < dataOfHeap[leftChild(position)]
            || dataOfHeap[position] < dataOfHeap[rightChild(position)]) {
 
        	 //swapping with left child and heapify it
            if (dataOfHeap[leftChild(position)]
                > dataOfHeap[rightChild(position)]) {
            	swapNodes(position, leftChild(position));
                heapify(leftChild(position));
            }
          //swapping with right child and heapify it
            else {
            	swapNodes(position, rightChild(position));
            	heapify(rightChild(position));
            }
        }
    }
 
    /**
     * It will insert an element into the heap
     * @param element
     */
    public void insert(int element)
    {
    	dataOfHeap[size] = element;
 
    	 // It will go up trough elementds and fix properties that were not met
        int current = size;
        while (dataOfHeap[current] > dataOfHeap[parent(current)]) {
        	swapNodes(current, parent(current));
            current = parent(current);
        }
        size++;
    }
 
    /**
     * It will print heap
     */
    public void print()
    {
       
      for(int i=0;i<size/2;i++){
 
            System.out.print("Parent Node : " + dataOfHeap[i] );
             
            if(leftChild(i)<size) //if the child is out of the bound of the array
               System.out.print( " Left Child Node: " + dataOfHeap[leftChild(i)]);
             
            if(rightChild(i)<size) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: "+ dataOfHeap[rightChild(i)]);
             
                System.out.println(); //for new line
             
        }
           
    }
 
    /**
     * It will remove an element from the heap
     * @return
     */
    public int extractMax()
    {
        int popped = dataOfHeap[1];
        dataOfHeap[1] = dataOfHeap[size--];
        heapify(1);
        return popped;
    }
 
   
    
}//end of heap method 
 
 
//Priority Queue
 class PriorityQ {
	 
	 /**
	  * To heapify
	  * @param list
	  * @param i
	  */
	  void heapify(ArrayList<Integer> list, int i) {
	    int size = list.size();
	    //To find the largest element between left, right child and root 
	    int largest = i;
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;
	    if ( left < size && list.get( left) > list.get(largest))
	      largest =  left;
	    if (right < size && list.get(right) > list.get(largest))
	      largest = right;

	    // If root is not the largets it will continue swapping and hepifying 
	    if (largest != i) {
	      int temp = list.get(largest);
	      list.set(largest, list.get(i));
	      list.set(i, temp);

	      heapify(list, largest);
	    }
	  }

	  /**
	   * It will insert a new element
	   * @param list
	   * @param newElement
	   */
	  void insert(ArrayList<Integer> list, int newElement) {
	    int size = list.size();
	    if (size == 0) {
	    	list.add(newElement);
	    } else {
	    	list.add(newElement);
	      for (int i = size / 2 - 1; i >= 0; i--) {
	        heapify(list, i);
	      }
	    }
	  }

	  /**
	   * It will delete element
	   * @param list
	   * @param element
	   */
	  void deleteNode(ArrayList<Integer> list, int element) {
	    int size = list.size();
	    int i;
	    for (i = 0; i < size; i++) {
	      if (element == list.get(i))
	        break;
	    }

	    int temp = list.get(i);
	    list.set(i, list.get(size - 1));
	    list.set(size - 1, temp);

	    list.remove(size - 1);
	    for (int j = size / 2 - 1; j >= 0; j--) {
	      heapify(list, j);
	    }
	  }

		 /**
	      * Insertion sort
	      */
	   void insertionSort(ArrayList<Integer>  list) {
		    for (int j = 1; j < list.size(); j++) {
		        int current = list.get(j);
		        int i = j-1;
		        while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
		            list.set(i+1, list.get(i));
		            i--;
		        }
		        list.set(i+1, current);
		    }
		}
	  
	   /**
	   * Selection sort
	   */  
	   void selectionSort(ArrayList<Integer>  list) {
		  
		   //it will pick one element at a time
		    for (int i = 0; i < list.size(); i++) {
		        int min = list.get(i);
		        int minIndex = i;
		       
		       //it will go through the list and compare min with the rest of the list,if num is smaller
		        //it will be assigned as the new min
		        for (int j = i + 1; j < list.size(); j++) {
		            if (list.get(j) < min) {
		                min = list.get(j);
		                minIndex = j;
		            }
		        }
		        if (i != minIndex) {
		           Collections.swap(list, i, minIndex);
		        }
		    }
		}

	  
	  
	  /**
	   * It will print array
	   * @param array
	   * @param size
	   */
	  void printArray(ArrayList<Integer> array, int size) {
	    for (Integer i : array) {
	      System.out.print(i + " ");
	    }
	    System.out.println();
	  }
	  
	}//end of pq class
 
 /**
  * Sorted PQ
  *
  */
 class SortPriorityQ extends PriorityQ{
	 
	 @Override
	void printArray(ArrayList<Integer> array, int size) {
		super.insertionSort(array);
		super.printArray(array, size);
	}

	@Override
	void heapify(ArrayList<Integer> list, int i) {
		super.heapify(list, i);
	}

	@Override
	 void insert(ArrayList<Integer> list, int newElement) {
		  super.insert(list, newElement);
		  }
	 
 }//end of sortedPq class
 

 
 
 
 
 