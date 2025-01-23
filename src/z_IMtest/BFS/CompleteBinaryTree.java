package z_IMtest.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<E> { // 데이터 종류를 몰라서...

    private Object[] nodes;//배열로 트리를 표시할거야 //당장은 메모리 생각을 안 할게.
    private int lastIndex = 0; // 마지막 노드의 인덱스
    private final int MAX_SIZE;

    // 1. 생성자
    public CompleteBinaryTree(int maxSize) {
        super();
        MAX_SIZE = maxSize;
        nodes = new Object[MAX_SIZE+1]; // 노드 저장 인덱스 1부터 사용.
    }

    public boolean isFull() {
        return lastIndex == MAX_SIZE;
    }
    public void add(E e) {
        if(isFull()) throw new RuntimeException("트리가 노드로 가득찼습니다.");

        nodes[++lastIndex] = e;
    }

    public  void BFS() {

        // 1. 순서를 관리할 큐를 준비
        Queue<Integer> queue = new ArrayDeque<>();

        // 2. 처음 탐색의 대상이 될 대상을 큐에 넣기;
        queue.offer(1); // 루트 노드 인덱스 넣기;

        // 3. 큐에 저장되어 있는 탐색다상들을 차례대로 꺼내어 방문!!
        while (!queue.isEmpty()) {
            // 4. 탐색 대상 꺼내기
            int cur = queue.poll();
            // 5. 탐색 대상 탐색하기 (대상으로 해야할 작업들 수행)
            System.out.print(nodes[cur]+"\t");
            // 6. 탐색 대상과 관계를 맺고 있는 대상들을 다음에 방문하기 위해 순서를 결정하는 큐에 넣기
            if (cur*2 <= lastIndex) queue.offer(cur*2); // 넘어가면 멈추겠지.
            if (cur*2+1 <= lastIndex) queue.offer(cur*2+1);
        }





    }


}
