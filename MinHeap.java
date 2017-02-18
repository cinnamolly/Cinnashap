import java.util.Arrays;

public class MinHeap {
    private static int CAPACITY;
    protected Node[] array;
    protected int size;
    
    /**
     * Constructs a new BinaryHeap.
     */
  
    public MinHeap (int capacity) {
        // Java doesn't allow construction of arrays of placeholder data types 
        CAPACITY = capacity;
        array = new Node[CAPACITY];  
        size = 0;
    }
    
    
    /**
     * Adds a value to the min-heap.
     */
    public void add(Node value) {
        // grow array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }        
        
        // place element into heap at bottom
        size++;
        int index = size;
        array[index] = value;
        
        bubbleUp();
    }
    
    
    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    
    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public Node peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        
        return array[1];
    }

    
    /**
     * Removes and returns the minimum element in the heap.
     */
    public Node remove() {
        // what do want return?
        Node result = peek();
        
        // get rid of the last leaf/decrement
        array[1] = array[size];
        array[size] = null;
        size--;
        
        bubbleDown();
        
        return result;
    }

    
    /**
     * Performs the "bubble down" operation to place the element that is at the 
     * root of the heap in its correct place so that the heap maintains the 
     * min-heap order property.
     */
    protected void bubbleDown() {
        int index = 1;
        
        // bubble down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);
            
            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index) && (array[leftIndex(index)].weight > array[rightIndex(index)].weight)) {
                smallerChild = rightIndex(index);
            } 
            
            if (array[index].weight > array[smallerChild].weight) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }
            
            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }        
    }
    
    
    /**
     * Performs the "bubble up" operation to place a newly inserted element 
     * (i.e. the element that is at the size index) in its correct place so 
     * that the heap maintains the min-heap order property.
     */
    protected void bubbleUp() {
        int index = this.size;
        
        while (hasParent(index) && (parent(index).weight > array[index].weight)) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }
    
    
    protected boolean hasParent(int i) {
        return i > 1;
    }
    
    
    protected int leftIndex(int i) {
        return i * 2;
    }
    
    
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    
    protected Node parent(int i) {
        return array[parentIndex(i)];
    }
    
    
    protected int parentIndex(int i) {
        return i / 2;
    }
    
    
    protected Node[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }
    
    
    protected void swap(int index1, int index2) {
        Node tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;        
    }
}

// public class MinHeap
// {
//     private Node[] Heap;
//     public int size;
//     private int maxsize;
 
//     private static final int FRONT = 1;
 
//     public MinHeap(int maxsize)
//     {
//         this.maxsize = maxsize;
//         this.size = 0;
//         Heap = new Node[this.maxsize + 1];
//         Heap[0] = new Node(-1, -1);
//     }
 
//     private int parent(int pos)
//     {
//         return pos / 2;
//     }
 
//     private int leftChild(int pos)
//     {
//         return (2 * pos);
//     }
 
//     private int rightChild(int pos)
//     {
//         return (2 * pos) + 1;
//     }
 
//     private boolean isLeaf(int pos)
//     {
//         if (pos >=  (size / 2)  &&  pos <= size)
//         { 
//             return true;
//         }
//         return false;
//     }
 
//     private void swap(int fpos, int spos)
//     {
//         Node tmp;
//         tmp = Heap[fpos];
//         Heap[fpos] = Heap[spos];
//         Heap[spos] = tmp;
//     }
 
//     private void minHeapify(int pos)
//     {
//         if (!isLeaf(pos))
//         { 
//             if ( Heap[pos].weight > Heap[leftChild(pos)].weight  || Heap[pos].weight > Heap[rightChild(pos)].weight)
//             {
//                 if (Heap[leftChild(pos)].weight < Heap[rightChild(pos)].weight)
//                 {
//                     swap(pos, leftChild(pos));
//                     minHeapify(leftChild(pos));
//                 }else
//                 {
//                     swap(pos, rightChild(pos));
//                     minHeapify(rightChild(pos));
//                 }
//             }
//         }
//     }
 
//     public void insert(Node element)
//     {
//         Heap[++size] = element;
//         int current = size;
 
//         while (Heap[current].weight < Heap[parent(current)].weight)
//         {
//             swap(current,parent(current));
//             current = parent(current);
//         }	
//     }
 
//     public void print()
//     {
//         for (int i = 1; i <= size / 2; i++ )
//         {
//             System.out.print(" PARENT : " + Heap[i].vertexName + ", " + Heap[i].weight 
//                 + " LEFT CHILD : " + Heap[2*i].vertexName + ", " + Heap[2*i].weight
//                 + " RIGHT CHILD :" + Heap[2 * i  + 1].vertexName + ", " + Heap[2*i + 1].weight);
//             System.out.println();
//         } 
//     }
 

//     public void minHeap()
//     {
//         for (int pos = (size / 2); pos >= 1 ; pos--)
//         {
//             minHeapify(pos);
//         }
//     }
 
//     public Node remove()
//     {
//         Node popped = Heap[FRONT];
//         Heap[FRONT] = Heap[size--]; 
//         minHeapify(FRONT);
//         return popped;
//     }
 
//     public static void main(String...arg)
//     {
//         System.out.println("The Min Heap is ");
//         MinHeap minHeap = new MinHeap(5);

//         randomGen random = new randomGen();

//         Node a = new Node(0, 5);
//         Node b = new Node(1, 7);
//         Node c = new Node(2, 2);
//         Node d = new Node(3, 6);
//         Node e = new Node(4, 10);

//         minHeap.insert(a);
//         minHeap.insert(b);
//         minHeap.insert(c);
//         minHeap.insert(d);
//         minHeap.insert(e);
//         minHeap.minHeap();
 
//         minHeap.print();
//         System.out.println("The Min val is " + minHeap.remove().vertexName);
//     }
// }