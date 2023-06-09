import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Asset } from '../models/Asset.model';
import { nse } from '../models/Nse';
import { Security } from '../models/Securities.model';
import { Theme } from '../models/Theme.model';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  // private baseUrl = "http://localhost:8899/api/composition";

  getTheme$ = new BehaviorSubject<Theme>({});

  constructor(private http:HttpClient) { }
  postSecurity(security:Security,portfolioName:string): Observable<any>{
    return this.http.post("http://localhost:8899/api/composition/new/"+portfolioName,security)
  }

  getAllSecurities(): Observable<Security[]>{
    return this.http.get<Security[]>("http://localhost:8899/api/composition/get");
  }
  // getSecurities(portfolioName:string): Observable<Security[]>{
  //   return this.http.get<Security[]>(`${this.http//localhost:8899/api/composition/get/security}?portfolioName=${portfolioName}`);
  // }

  deleteSecurity(securityName:string): Observable<Object>{
    return this.http.delete(`http://localhost:8899/api/composition/delete/${securityName}`);
  }

  postTheme(theme:Theme): Observable<any>{
    return this.http.post("http://localhost:8899/api/add/theme",theme);
  }

  postAsset(asset:Asset,themeId): Observable<any>{
    return this.http.post("http://localhost:8899/api/new/"+themeId,asset);
  }

  getAllstocks(){
    return this.http.get<nse[]>("http://localhost:8899/api/stocks/all")
  }

  getSecurityByPortfolioName(portfolioName:string): Observable<Security[]>{
       return this.http.get<Security[]>('http://localhost:8899/api/composition/get/security/'+portfolioName);
     }

     getAssetByThemeName(themeName:string): Observable<Asset[]>{
      return this.http.get<Asset[]>('http://localhost:8899/api/asset/'+themeName);
    }

    getAsset(): Observable<Asset[]>{
      return this.http.get<Asset[]>('http://localhost:8899/api/get')
    }


    getStockByAsset(assetId: any): Observable<nse[]>{
      return this.http.get<nse[]>('http://localhost:8899/api/stocks/asset/'+assetId);
    }
}