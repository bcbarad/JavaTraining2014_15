import java.util.List;
import java.util.*;


public class Company {
    String companyName;
    String url;
    List<Deportment> dept;

    public Company() {
    }

    public Company(String companyName, String url, List<Deportment> dept) {
        this.companyName = companyName;
        this.url = url;
        this.dept = dept;
    }

    public List<Deportment> enteringvaluestoArray(List<Deportment> dept, Scanner sc) {
        System.out.println("\n enetr company name:");
        String cmpname = sc.next();
        System.out.println("\n enetr url of the company");
        String url = sc.next();
        boolean flag = false;
        String name;
        String hod;
        List<Employee> emp;
        Deportment d = new Deportment();

        while(!flag) {

            System.out.println("\n enetr dept name:");
            name = sc.next();
            System.out.println("\n enetr HOD name:");
            hod = sc.next();
            System.out.println("\n enetr emp details");
            emp = d.enteringvaluestoArrayList(sc);
            dept.add(new Deportment(name, hod, emp));
            System.out.println("\n enetr yes or no");
            String decision = sc.next();
            if(decision.equals("no")) {
                flag = true;
            }
        }
        return dept;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Deportment> dept = new ArrayList<Deportment>();
        Company c = new Company();
        List<Deportment> deptm = c.enteringvaluestoArray(dept, sc);

        Iterator<Deportment> itr = dept.iterator();
        while(itr.hasNext()) {
            Deportment d = itr.next();
            System.out.println("dept name" + d.deportmentName + " head of deport ment " + d.headOfDeptName);
            System.out.println(d.deportmentName + " employees details");
            Iterator<Employee> itr2 = d.employee.iterator();
            while(itr2.hasNext()) {
                Employee em = itr2.next();
                System.out.println("emp name " + em.empname + " emp id " + em.id + " salary " + em.salary + " manager id " + em.managerId);
            }
         }

         Map<Integer, Integer> m = c.printLongestChain(deptm);
         int managerid = c.longestChain(m);
         System.out.println("\n manger id who has longest chain is :" +managerid);


    }
    public int longestChain(Map<Integer, Integer> map) {
        Set<Integer> keys = map.keySet();
        Integer i = 0;
        for (Integer id : keys) {
            if (i < id) {
                i = id;
             }
            System.out.println(map.get(id));
        }

        int idm = map.get(i).intValue();
        return idm;
   }



        public Map<Integer, Integer> printLongestChain(List<Deportment> deptm) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            //int count = 0;
            for (Deportment d : deptm) {
                for (Employee e : d.employee) {
                    int id = e.id;
                    int mid = e.managerId;
                    int count = 0;
                    for (Employee e1: d.employee) {
                        if (mid == e1.id) {
                            mid = e1.managerId;
                            count ++;
                        }
                        Integer ido = (Integer) mid;
                        Integer count1 = (Integer) count;
                        map.put(count1, ido);
                  /*  Iterator<Employee> itr = d.employee.iterator();
                     while(itr.hasNext()) {
                         int count = 0;
                         Employee e2 = itr.next();
                         if (mid == e.id) {
                             mid = e.managerId;
                             count ++;

                         }
                     Integer ido = (Integer) mid;
                     Integer count1 = (Integer) count;
                     map.put(count1, ido);
                     }*/
                  }
                }
            }
            return map;
    }

}

    class Deportment {
        String deportmentName;
        String headOfDeptName;
        List<Employee> employee;

        public Deportment() {
        }

        public Deportment(String deportmentName, String headOfDeportment, List<Employee> emp) {
            this.deportmentName = deportmentName;
            this.headOfDeptName = headOfDeportment;
            this.employee = emp;
        }
        public List<Employee> enteringvaluestoArrayList(Scanner sc) {
            String name;
            List<Employee> employee = new ArrayList<Employee>();
            int id,mid;
            float salary;
            // SimpleDateFormat date;
            boolean flag = false;

            while(!flag) {
                System.out.println("\n eneter emp name:");
                name = sc.next();
                System.out.println("\n enetr emp id:");
                id = sc.nextInt();
                System.out.println("\n enetr salary:");
                salary = sc.nextFloat();
                System.out.println("\n enetr managed id:");
                mid = sc.nextInt();
                employee.add(new Employee(name,id,salary,mid));

                System.out.println("\n enetr yes or no:");
                String s = sc.next();
                if(s.equals("no")) {
                    flag = true;
                }
            }

            return employee;
        }
    }
    class Employee {
        String empname;
        int id;
        float salary;
        int managerId;
        //    SimpleDateFormat date;

        public Employee(String name, int id, float sal,int mid) {
            this.empname = name;
            this.id = id;
            this.salary = sal;
            this.managerId = mid;
        }
    }
