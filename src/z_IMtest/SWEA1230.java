import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA1230 {
    // x 위치에서 바로 다음 y개 숫자s 삽입
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t < 11; t++) {

            SinglyLinkedList list = new SinglyLinkedList();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < N; idx++) {
                list.addData(Integer.parseInt(st1.nextToken()));
            }
            N = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) {
                String IDA = st2.nextToken();
                if (IDA.equals("I")) {
                    int x = Integer.parseInt(st2.nextToken());
                    int y = Integer.parseInt(st2.nextToken());

                    for (int l = 0; l < y; l++) {
                        list.insertData(x, Integer.parseInt(st2.nextToken()));
                        x++;
                    }
                } else if (IDA.equals("D")) {
                    int x = Integer.parseInt(st2.nextToken());
                    int y = Integer.parseInt(st2.nextToken());

                    list.deleteData(x, y);
                } else {
                    int x = Integer.parseInt(st2.nextToken());
                    for (int i =0; i<x; i++) {
                        list.addData(Integer.parseInt(st2.nextToken()));
                    }

                }
            }

            bw.write("#" + t);
            Node curr = list.head;
            for (int i = 0; i < 10; i++) {
                curr = curr.link;
                bw.write(" " + curr.data);
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    int data;
    Node link;
}

class SinglyLinkedList {

    Node head = new Node();

    public SinglyLinkedList() {
        head = new Node();
    }

    void addData(int Data) {
        Node newNode = new Node();
        newNode.data = Data;

        Node curr = head;
        while (curr.link != null) {
            curr = curr.link;
        }
        curr.link = newNode;
    }

    void insertData(int idx, int Data) {

        Node curr = head;
        for (int i = 0; i < idx; i++) {
            curr = curr.link;
        }
        Node newNode = new Node();
        newNode.data = Data;
        newNode.link = curr.link;
        curr.link = newNode;
        curr = curr.link;
    }
    void deleteData(int idx, int num ) {

        Node curr = head;
        for (int i = 0; i < idx; i++) {
            curr = curr.link;
        }
        Node tmp = curr;
        for (int i = 0; i < num; i++) {
            tmp = tmp.link;
        }
        curr.link = tmp.link;
    }
}