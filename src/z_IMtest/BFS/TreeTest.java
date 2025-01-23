package z_IMtest.BFS;

public class TreeTest {
    public static void main(String[] args) {

        String[] names = {"A", "B", "C", "D", "E","F"};

        CompleteBinaryTree<String> tree = new CompleteBinaryTree<>(names.length);
        //해당 인스턴스는 len+1 인 노드 배열을 가지고 있다!!!

        for (String name : names) {
            tree.add(name);
        }
        tree.BFS();
    }
}
