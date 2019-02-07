import java.util.ArrayList;
import java.util.Scanner;

public class Store
{
    private ArrayList<Customer> customers;

    public Store()
    {
        customers = new ArrayList<Customer>();
    }

    public void addSale()
    {
        String name;
        double sales = 0;
        Scanner s = new Scanner (System.in);
        System.out.println ("Enter a name: ");
        name = s.next();

        System.out.println("Enter sales: (when done type 'done') ");
        while (s.hasNextDouble())
        {
            sales += s.nextDouble();
        }

        Customer customer = new Customer(name, sales);
        customers.add(customer);
    }

    public void addAllSales()
    {
        Scanner s = new Scanner (System.in);
        char yesOrNo = 'y';
        while (yesOrNo == 'y')
        {
            addSale();
            System.out.println("Add another customer? (y/n): ");
            yesOrNo = s.next().charAt(0);
        }

        for (int i = 0; i < customers.size(); i ++)
        {
            Customer c = customers.get(i);
            c.print();
        }
    }

    public String nameOfBestCustomer()
    {
        Customer curr = customers.get(0);
        double max = curr.getSale();
        String maxName = curr.getName();
        for (int i = 1; i< customers.size(); i++)
        {
            curr = customers.get(i);
            double temp = curr.getSale();
            if (temp > max)
            {
                max = temp;
                maxName = curr.getName();
            }
        }

        return maxName;
    }

    public ArrayList<String> topNCustomers(int topN)
    {
        ArrayList<String> top = new ArrayList<String>();

        int n = topN;
        if (n > customers.size()) n = customers.size();
        for (int x = 0; x< n; x++)
        {
            
            Customer curr = customers.get(0);
            double max = curr.getSale();
            int maxIndex = 0;
            for (int i = 1; i< customers.size(); i++)
            {
                curr = customers.get(i);
                double temp = curr.getSale();
                if (temp > max)
                {
                    max = temp;
                    maxIndex = i;
                }
            }
            top.add(customers.get(maxIndex).getName());
            customers.remove(maxIndex);
        }
        
        return top;
    }

    
    public static void main(String[] args)
    {
        Store store = new Store();
        store.addAllSales();
        System.out.println("Best customer: " + store.nameOfBestCustomer());
        System.out.println("How many top customers? ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        System.out.println("Best N Customers: " + store.topNCustomers(n));
    }
}
