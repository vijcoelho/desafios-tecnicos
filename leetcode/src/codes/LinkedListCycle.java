package codes;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode primeiro;

    public void inserir(int i) {
        ListNode novo = new ListNode(i);
        novo.next = this.primeiro;
        this.primeiro = novo;
    }

    public void imprimir() {
        ListNode atual = this.primeiro;
        while (atual != null) {
            System.out.println(atual.val + " ");
            atual = atual.next;
        }
        System.out.println();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.inserir(10);
        linkedListCycle.inserir(20);
        linkedListCycle.inserir(30);
        linkedListCycle.inserir(40);

        linkedListCycle.imprimir();

        System.out.println(linkedListCycle.hasCycle(linkedListCycle.primeiro));
    }
}