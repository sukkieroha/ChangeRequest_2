public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String sssNumber;
    private String philHealthNumber;
    private String tin;
    private String pagIbigNumber;
    private double hourlyRate;
    private double riceAllowance;
    private double phoneAllowance;
    private double clothingAllowance;

    public Employee(int employeeNumber, String lastName, String firstName, String sssNumber,
                    String philHealthNumber, String tin, String pagIbigNumber,
                    double hourlyRate, double riceAllowance, double phoneAllowance,
                    double clothingAllowance) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philHealthNumber;
        this.tin = tin;
        this.pagIbigNumber = pagIbigNumber;
        this.hourlyRate = hourlyRate;
        this.riceAllowance = riceAllowance;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    public Employee(int employeeNumber, String lastName, String firstName, double grossPay, String payPeriod) {
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getPhilhealthNumber() {
        return philHealthNumber;
    }

    public void setPhilHealthNumber(String philHealthNumber) {
        this.philHealthNumber = philHealthNumber;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getPagIbigNumber() {
        return pagIbigNumber;
    }

    public void setPagIbigNumber(String pagIbigNumber) {
        this.pagIbigNumber = pagIbigNumber;
    }

    // methods for calculating weekly salary, etc.//
    public double computeBasicPay() {
        double hoursWorked = 0;
        double basicPay = hourlyRate * hoursWorked;
        return basicPay;
    }

    public double computeGrossPay(double basicPay) {
        return computeBasicPay() + computeAllowances();
    }

    public double computeAllowances() {
        double riceAllowance = this.riceAllowance / 4;
        double phoneAllowance = this.phoneAllowance / 4;
        double clothingAllowance = this.clothingAllowance / 4;
        double totalAllowances = riceAllowance + phoneAllowance + clothingAllowance;

        return totalAllowances;
    }

    public double computeSSSDeduction(double basicPay) {
        double sssDeduction = 0.0;
        if (basicPay >= 1000.00 && basicPay <= 1249.99) {
            sssDeduction = 36.30;
        } else if (basicPay >= 1250.00 && basicPay <= 1749.99) {
            sssDeduction = 54.50;
        } else if (basicPay >= 1750.00 && basicPay <= 2249.99) {
            sssDeduction = 72.70;
        } else if (basicPay >= 2250.00 && basicPay <= 2749.99) {
            sssDeduction = 90.80;
        }
        return sssDeduction;
    }

    private double computeTax(double taxableIncome) {
        double taxDeduction = 0.0;
        if (taxableIncome > 250000) {
            double taxableAmount = taxableIncome - 250000;
            if (taxableAmount <= 400000) {
                taxDeduction = taxableAmount * 0.2;
            } else if (taxableAmount <= 800000) {
                taxDeduction = 40000 + ((taxableAmount - 400000) * 0.25);
            } else {
                taxDeduction = 200000 + ((taxableAmount - 800000) * 0.3);
            }
        }
        return taxDeduction;
    }
    private double computeNetPay(double basicPay, double taxableIncome){
        double sssDeduction = computeSSSDeduction( basicPay);
        double philHealthDeduction = computeBasicPay() * .03;
        double pagIbigDeduction = computeBasicPay() * .03;
        return computeGrossPay(basicPay) - sssDeduction - philHealthDeduction - pagIbigDeduction - computeTax( taxableIncome);
    }
}
