package com.lex.showcase.algorithm.heap;


import java.util.Arrays;
import java.util.Objects;

public class MaxHeap<T extends Comparable<T>> {
    private Comparable<T>[] array;
    private int N; // 堆大小

    public MaxHeap(int maxN) {
        this.array = new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int length) {
        MaxHeap<T> newArray = new MaxHeap<T>(length);
        for (int i = 0; i < length; i++) {
            newArray.array[i] = array[i];
        }
    }

    /**
     * 上浮
     *
     * @param k
     */
    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉
     *
     * @param k
     */
    public void sink(int k) {
        while(2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    // 从末尾插入，然后执行上浮操作以修复数据结构
    public void insert(Comparable<T> item) {
        array[++N] = item;
        swim(N);
    }

    // 删除顶部节点
    // 1）将顶部节点值保存；2）交换末尾节点和顶部节点；3）顶部节点执行下沉操作以修复数据结构；4）堆数据量减一，释放末尾节点对象。
    public Comparable<T> delMax() {
        Comparable<T> maxItem = array[1];
        exch(1, N--);
        array[N + 1] = null; // 防止产生无用的游离对象
        sink(1); // 恢复堆的有序性
        return maxItem;
    }

    private void exch(int j, int k) {
        Comparable<T> t = array[j];
        array[j] = array[k];
        array[k] = t;
    }

    private boolean less(int j, int k) {
        return array[j].compareTo((T) array[k]) < 0;
    }

    public static void main(String[] args) {
        MaxHeap<String> heap = new MaxHeap<>(5);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");

        System.out.println(Arrays.toString(heap.array));
    }
}
