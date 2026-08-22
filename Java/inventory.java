import java.util.*;

class Inventory{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> arr = new ArrayList<>();

        for(int i=0; i<3; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<3; i++){
            System.out.println("Insert Stock for section "+i+": ");
            for(int j=0; j<3; j++){
                arr.get(i).add(sc.nextInt());
            }
        }

        LinkedList<Integer> lowStock = new LinkedList<>();

        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.get(i).size(); j++){
                if(arr.get(i).get(j)<5) lowStock.add(2*arr.get(i).get(j));
            }
        }

        System.out.println("Original inventory: ");
        for(int i=0; i<arr.size(); i++){
            System.out.println("Section "+i+": "+arr.get(i));
        }

        System.out.println("Target: "+lowStock);
    }
}
