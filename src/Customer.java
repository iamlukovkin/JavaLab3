import java.util.ArrayList;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCardNumber;
    private int bankAccountNumber;

    public Customer() {
        this.id = 0;
        this.surname = "";
        this.name = "";
        this.patronymic = "";
        this.address = "";
        this.creditCardNumber = 0;
        this.bankAccountNumber = 0;
    }

    public Customer(int id) {
        this.id = id;
        this.surname = "CustomerSurname" + id;
        this.name = "CustomerName" + id;
        this.patronymic = "CustomerPatronymic" + id;
        this.address = "CustomerAddress" + id;
        this.creditCardNumber = id;
        this.bankAccountNumber = id;
    }

    public Customer(int id, String surname, String name, String patronymic, String address, int creditCardNumber, int bankAccountNumber) {
        setId(id);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAddress(address);
        setCreditCardNumber(creditCardNumber);
        setBankAccountNumber(bankAccountNumber);
    }

    public static ArrayList<Customer> getCustomersOrderedBySurname(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size() - 1; i++) {
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(i).getSurname().compareTo(customers.get(j).getSurname()) > 0) {
                    Customer temp = customers.get(i);
                    customers.set(i, customers.get(j));
                    customers.set(j, temp);
                }
            }
        }
        return customers;
    }

    public static ArrayList<Customer> getCustomersOrderedByCardNumberRange(ArrayList<Customer> customers, int min, int max) {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCreditCardNumber() >= min && customer.getCreditCardNumber() <= max) {
                result.add(customer);
            }
        }
        return result;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            this.id = 0;
        }
    }

    public void setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        } else {
            this.surname = "";
        }
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "";
        }
    }

    public void setPatronymic(String patronymic) {
        if (patronymic != null) {
            this.patronymic = patronymic;
        } else {
            this.patronymic = "";
        }
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        } else {
            this.address = "";
        }
    }

    public void setCreditCardNumber(int creditCardNumber) {
        if (creditCardNumber >= 0) {
            this.creditCardNumber = creditCardNumber;
        } else {
            this.creditCardNumber = 0;
        }
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        if (bankAccountNumber >= 0) {
            this.bankAccountNumber = bankAccountNumber;
        } else {
            this.bankAccountNumber = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    @Override
    public String toString() {
        return getId() + ": " + getSurname() + " " + getName() + " " + getPatronymic() + "\n" + getAddress() + "\nНомер кредитной карточки: " + getCreditCardNumber() + "\nНомер банковского счета: " + getBankAccountNumber();
    }
}
