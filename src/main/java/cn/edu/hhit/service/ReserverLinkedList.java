package cn.edu.hhit.service;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/1515:24
 */
public class ReserverLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        node1.name = "node1";
        node1.next = node2;
        node2.name = "node2";
        node2.next = node3;
        node3.name = "node3";
        node3.next = node4;
        node4.name = "node4";
        node4.next = node5;
        node5.name = "node5";
        node5.next = node6;
        node6.name = "node6";
        node6.next = node7;
        node7.name = "node7";
        node7.next = node8;
        node8.name = "node8";
        node8.next = null;
        System.out.println(ReserverLinkedList.recver(node1).name);
        System.out.println(node8.name);
    }
    public static Node recver(Node head){
        if(head==null||head.next==null){
            return head;
        }else {
            Node headNode = recver(head.next);
            head.next.next = headNode;
            head.next = null;
            return headNode;
        }
    }
}
