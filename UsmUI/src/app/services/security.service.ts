import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Security } from '../models/Securities.model';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  private baseUrl = "http://localhost:8899/api/composition";

  constructor(private http:HttpClient) { }
  postSecurity(security:Security): Observable<any>{
    return this.http.post("http://localhost:8899/api/composition/new",security)
  }

  getAllSecurities(): Observable<Security[]>{
    return this.http.get<Security[]>("http://localhost:8899/api/composition/get");
  }

  deleteSecurity(securityName:string): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/${securityName}`);
  }
}
