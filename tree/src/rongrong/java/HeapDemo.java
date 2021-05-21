package rongrong.java;

/**
 * @description��
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
        private int[] element;//�洢�ѵ�Ԫ�غͶ�Ԫ�صĸ������±�Ϊ0��λ�������洢��Ԫ�صĸ�������Ԫ�ظ���+1��

        public Heap(int maxSize) {
            element = new int[maxSize];
            element[0] = 0;//�տ�ʼ��Ԫ�ظ���Ϊ0
        }

        /**
         * �ж��Ƿ�Ϊ�ն�
         */
        public boolean isEmpty() {
            return element[0] == 0;
        }

        /**
         * �ж��Ƿ����
         */
        public boolean isFull() {
            return element.length - 1 == element[0];
        }

        /**
         * �󶥶����һ����Ԫ��
         *
         * @param value
         */
        public void insert(int value) {
            if (isFull()) {
                throw new IndexOutOfBoundsException("�󶥶��Ѿ�����");
            }
            if (isEmpty()) {//���ﲻ���ж�Ҳ��
                element[1] = value;
            } else {
                int i = element[0] + 1;//ȷ����Ԫ�ص��±�
                while (i != 1 && value > element[i / 2]) {
                    //����ȸ��ڵ��ֵ���򸸽ڵ��ֵ����
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
