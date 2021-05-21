package rongrong.java;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-04-21 10:21
 */
public class HeapDemo {
    public static void main(String[] args) {
        Heap heap = new Heap(20);
        heap.insert(40);
        heap.insert(15);
        heap.insert(50);
        heap.insert(20);
        heap.insert(35);
        heap.insert(25);
        heap.insert(30);
        heap.insert(10);
        heap.insert(45);
        heap.printAll();
    }
}
    class Heap {
        private int[] element;//存储堆的元素和堆元素的个数，下标为0的位置用来存储堆元素的个数（堆元素个数+1）

        public Heap(int maxSize) {
            element = new int[maxSize];
            element[0] = 0;//刚开始堆元素个数为0
        }

        /**
         * 判断是否为空堆
         */
        public boolean isEmpty() {
            return element[0] == 0;
        }

        /**
         * 判断是否堆满
         */
        public boolean isFull() {
            return element.length - 1 == element[0];
        }

        /**
         * 大顶堆添加一个新元素
         *
         * @param value
         */
        public void insert(int value) {
            if (isFull()) {
                throw new IndexOutOfBoundsException("大顶堆已经满了");
            }
            if (isEmpty()) {//这里不做判断也可
                element[1] = value;
            } else {
                int i = element[0] + 1;//确认新元素的下标
                while (i != 1 && value > element[i / 2]) {
                    //如果比父节点的值大，则父节点的值下移
                    element[i] = element[i / 2];
                    i /= 2;
                }
                element[i] = value;
            }
            element[0]++;
        }
        public void printAll(){
            for (int i = 1; i < element.length-2; ++i) {
                System.out.print(element[i] + ",");
//                if (i != element[0]){
//                    System.out.print(",");
//                }
            }
            System.out.println();
        }
    }
