# empPTOSystem

Java Coding Test

Requirements
1. Write classes in Java to represent 3 different types of Employee – hourly employees, salaried
employees, and managers (also considered salaried employees)
2. Each employee has a floating-point property for number of vacation days accumulated for the work year
(defined as 260 workdays) which cannot be a negative value and is not writable externally. Upon
creation its value should be set to 0.
3. Hourly employees accumulate 10 vacation days during the work year.
4. Salaried employees accumulate 15 vacation days during the work year.
5. Managers accumulate 30 vacation days during the work year.


6. Each employee has a Work() method that takes a single integer parameter that defines the number of
days worked which should be a value between 0 and 260. When this method is called, the number of
vacation days accumulated should be updated appropriately.
7. Each employee also has a TakeVacation() method that takes a single floating-point parameter that
defines the number of vacation days used. When this method is called, the number of vacation days
accumulated should be updated appropriately.
8. An employee cannot work more than the number of workdays in a work year and cannot take more
vacation than is available.
9. Your application should create a list of 10 instances of each type of employee on startup. No database is
required.

A web interface should show the current status of each employee and contain controls that enable the
two methods defined above to be called. After each action the UI should update to reflect the current
status of the employees.


Tools and technologies
Java, Spring boot, Angular
