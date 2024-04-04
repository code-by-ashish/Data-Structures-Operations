import java.util.Scanner;

public class LinkedLists {
    static int num = 0;
    static class node{
        int data;
        node next;

        //constructor
        node(int val){
            this.data = val;
            this.next = null;
        }
    }
    static node head = null; //head start as a null

    //display
    static void displayList(){
        if(head==null){
            System.out.println("\nList is Empty!\n");
            return;
        }

        node n = head;
        System.out.print("\nLinked List elements are: ");
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println("\n");
    }

    //insert a node
    static void insertNode(int val){
        node newNode = new node(val);

        if(head==null){
            head = newNode;
        }else{
            node n = head;
            while(n.next!=null){
                n = n.next;
            }
            n.next = newNode;
        }
        System.out.println("\nNode inserted!\n");
        num++;
        System.out.println();
    }

    //deletion
    static void deleteNode(int n){
        if(head==null){
            System.out.println("\nList is already empty!\n");
            return;
        }

        node temp = head;
        if(n==1){
            temp = temp.next;
            head = temp;
        }else{
        for(int i=1; i<n-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
        System.out.println("\nNode Deleted!\n");
        num--;
    }

    //update node
    static void updateNode(int val, int n){
        node temp = head;
        for(int i=0; i<n-1; i++){
            temp = temp.next;
        }
        temp.data = val;
        System.out.println("\nNode Updated!\n");
    }

    //search list
    static int searchNode(int val){
        if(head==null) return 0;

        node temp = head;
        for(int i=0; i<num; i++){
            if(temp.data == val) return i+1;
            temp = temp.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** Linked List Operations ***");
        System.out.println("\n");

        int choice;

        do{
            System.out.println("1. Display the List");
            System.out.println("2. Insert a Node");
            System.out.println("3. Delete a Node");
            System.out.println("4. Update a Node");
            System.out.println("5. Search a Node");
            System.out.println("6. Exit the Loop");
            System.out.print("\nChoose an option: ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:{
                    displayList();
                    break;
                }
                case 2:{
                    System.out.print("\nEnter a value to insert in a node: ");
                    int val = sc.nextInt();
                    insertNode(val);
                    break;
                }
                case 3:{
                    if(num<1){
                        System.out.println("\nList is already empty!\n");
                    }else{
                    System.out.print("\nEnter the node number you want to delete: ");
                    int node = sc.nextInt();
                    
                    if(node>num){
                        System.out.println("\nNode is out of bound!\n");
                    }else{
                        deleteNode(node);
                    }
                    }
                    break;
                }
                case 4:{
                    if(num<1){
                        System.out.println("\nList is empty!\n");
                    }else{
                    System.out.print("\nEnter the node number you want to update: ");
                    int n = sc.nextInt();
                    if(n>num || n<0){
                        System.out.println("\nNode is out of bound!\n");
                    }else{
                        System.out.print("\nEnter the value you want to update with: ");
                        int val = sc.nextInt();
                        updateNode(val, n);
                    }
                }
                    break;

                }
                case 5:{
                    if(num<1){
                        System.out.println("\nList is empty!\n");
                    }else{
                    System.out.print("\nEnter a value to search in List: ");
                    int val = sc.nextInt();
                    int node = searchNode(val);

                    if(node==0){
                        System.out.println("\nList is empty!\n");
                    }else if(node == -1){
                        System.out.println("\nThis value doesn't exists in the List!\n");
                    }else{
                        System.out.println("\nValue is present at node "+node+"\n");
                    }
                }
                    break;
                }
                case 6:{
                    System.out.println("\nThanks!\n");
                    break;
                }
                default: {
                    System.out.println("\nYou have entered a wrong choice. Please choose again!\n");
                }
            }
        }while(choice!=6);

        sc.close();
    }
}
