import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Security } from '../models/Securities.model';
import { Theme } from '../models/Theme.model';

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
    return this.http.delete(`http://localhost:8899/api/composition/delete/${securityName}`);
  }

  postTheme(theme:Theme): Observable<any>{
    return this.http.post("http://localhost:8899/api/add/theme",theme);
  }
}
