import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Portfolio } from '../models/Portfolio.model';

@Injectable({
  providedIn: 'root'
})
export class PortfolioheaderService {

  private baseUrl = "http://localhost:8899/api/portfolio";
  private baseurl1= "http://localhost:8899/api"

  constructor(private http:HttpClient) { }
  postPortfolio(portfolio:Portfolio): Observable<any>{
    return this.http.post(`${this.baseUrl}`,portfolio)
  }
  getTheme():Observable<any>{
    return this.http.get(`${this.baseurl1}/${this.getTheme}`);
  }

  getAllPortfolios(): Observable<Portfolio[]>{
    return this.http.get<Portfolio[]>(`${this.baseUrl}`);
  }

  deletePortfolio(portfolioName:string): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/${portfolioName}`);
  }

  // getTheme():Observable<object>{
  //   return this.http.get(`${this.baseUrl}/${themeName}`);
  // }

}
