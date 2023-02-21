import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/emp';

  constructor(private http : HttpClient) { }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getEmployee(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  workEmployee(id:string, daysWorked:number) : Observable<Object> {
    var workUrl = `${this.baseUrl}/work/${id}?daysWorked=` + daysWorked;
    return this.http.post(workUrl, null);
  }

  takeVacayEmployee(id:string, vacay:number) : Observable<Object> {
    var vacayUrl = `${this.baseUrl}/vacation/${id}?vacay=` + vacay;
    return this.http.post(vacayUrl, null);
  }

  updateEmployee(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmployee(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
