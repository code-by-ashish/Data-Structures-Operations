import java.util.Scanner;

public class Arrays{
    //global variables
    static int[] arr = new int[100];
    static int choice, n;

    //display the array
    static void displayArray(int n){
        if(n==0){
            System.out.println("\nArray is empty!\n");
            return;
        }

        System.out.print("\nArray elements are: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    //searching
    static int searchArray(int num){
        if(n==0) return 0;

        for(int i=0; i<n; i++ ){
            if(arr[i]==num) return i;
        }
        return -1;
    }

    //update
    static void updateArray(int index, int element){
        if(n==0){
            System.out.println("\nArray is Empty!\n");
            return;
        }

        if(index>n){
            System.out.println("\nIndex is out of bound.\n");
            return;
        }

        arr[index] = element;
        System.out.println("\nArray Updated!");
        System.out.println();
    }

    //deletion
    static void deleteElement(int index){
        if(n==0){
            System.out.println("\nArray is already empty!");
            return;
        }

        if(index>n){
            System.out.println("\nThis index is out of bound!");
            return;
        }

        for(int i=index; i<n-1; i++){
            arr[i] = arr[i+1];
        }
        n--;
        System.out.println("\nIndex Deleted!");
        System.out.println();
    }

    //insert element
    static void insertElement(int index, int element){
        if(index>n || index<0){
            System.out.println("\nIndex out of bound");
            return;
        }

        n++;
        for(int i=n; i>index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        System.out.println("\nElement added!");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Welcome to Array Operations ***\n\n");
        do{
            System.out.println("1. Fill the Array");
            System.out.println("2. Display the Array");
            System.out.println("3. Search in the Array");
            System.out.println("4. Update an Element");
            System.out.println("5. Remove an Element");
            System.out.println("6. Insert an Element");
            System.out.println("7. Exit the loop!");
            System.out.println();
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            //switch cases
            switch(choice){
                //adding elements
                case 1:{
                    System.out.print("\nHow much elements you want? (Between 0 to 100) => ");
                    n = sc.nextInt();

                    System.out.println("\nEnter array elements -> ");
                    for(int i=0; i<n; i++){
                        System.out.print("Element "+i+"th -> ");
                        arr[i] = sc.nextInt();
                    }
                    System.out.println("\nElements added!");
                    System.out.println();
                    break;
                }

                //display array
                case 2:{
                    displayArray(n);
                    System.out.println("\n");
                    break;
                }

                //search array
                case 3:{
                    System.out.print("\nEnter an element you want to search: ");
                    int num = sc.nextInt();

                    int index = searchArray(num);
                    if(index==0){
                        System.out.println("\nArray is Empty!");
                    }else if(index==-1){
                        System.out.println("\nElement not found!");
                    }else{
                        System.out.println("\nElement available at index "+index+".");
                    }
                    
                    System.out.println();
                    break;
                }

                //update array
                case 4:{
                    System.out.print("\nEnter the index you want to change: ");
                    int index = sc.nextInt();
                    
                    System.out.print("\nEnter the element you want to update with: ");
                    int element = sc.nextInt();

                    updateArray(index, element);
                    break;
                }

                //delete element
                case 5:{
                    System.out.print("\nEnter the index you want to delete: ");
                    int index = sc.nextInt();
                    deleteElement(index);
                    break;
                }

                //insert element
                case 6:{
                    System.out.print("\nEnter the element you want to insert: ");
                    int element = sc.nextInt();

                    System.out.print("\nEnter the index at which you want to insert this element: ");
                    int index = sc.nextInt();

                    insertElement(index, element);
                    break;
                }

                //exit
                case 7:{
                    System.out.println("\nThanks!");
                    break;
                }
            }
        }while(choice!=7);
        sc.close();
    }
}