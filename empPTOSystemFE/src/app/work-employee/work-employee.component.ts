import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-work-employee',
  templateUrl: './work-employee.component.html',
  styleUrls: ['./work-employee.component.css']
})
export class WorkEmployeeComponent implements OnInit {

  id!: string;
  daysWorked!:number;
  employee: Employee = new Employee();

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();

    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getEmployee(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.daysWorked = (<HTMLInputElement>document.getElementById("daysWorked")).valueAsNumber;
    this.employeeService.workEmployee(this.id, this.daysWorked)
      .subscribe(data => {
        console.log(data);
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }
}
