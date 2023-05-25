import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { stringify } from 'querystring';
import { allstocks } from 'src/models/allstocks';
import { nse } from '../models/Nse';
import { Portfolio } from '../models/Portfolio.model';
import { Security } from '../models/Securities.model';


import { AllStocksService } from '../services/all-stocks.service';
import { PortfolioheaderService } from '../services/portfolioheader.service';
import { SecurityService } from '../services/security.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {
  public securityArray: Security[];
  securityName:string;
  investmentValue:any;
  // InvestmentValue:any;
  // stocksArr1:allstocks[];
  stocksArr1:nse;
  searchSecurityName: any;
  createPortForm: FormGroup;
  security:Security;
  stock:nse[];
  nse:any;
  selected:string;
  last:any;
  total:any;
  portfolioName:string;
  availableBalance:any;
  portfolio:Portfolio;
  constructor(private allStocksService:AllStocksService,
    private securityService:SecurityService,
      public http:HttpClient,
      public formgroup:FormBuilder,
      private route:Router,private portfolioService:PortfolioheaderService
      ) { }

  ngOnInit(): void {
    this.securityService.getAllSecurities().subscribe(data =>{
      this.securityArray = data;
    });
    this.securityService.getAllstocks().subscribe(data=>{
      this.stock=data;
    })
      this.searchSecurityName = this.formgroup.group({ 
      securityName:'',
      units:'',
      price:'',
      total:'',
      transactionDate:'',
      
    });
  }
  getSecurities(){
    this.securityService.getAllSecurities().subscribe(data =>{
      this.securityArray = data;
    })
  }
   
  deleteSecurity(securityName:string){
    this.getSecurities();
    this.securityService.deleteSecurity(securityName).subscribe(data =>{
    });
    // confirm('Deleted!!');
    let text;
if (confirm("Press a button!") == true) {
  text = "You pressed OK!";
} else {
  text = "You canceled!";
}
    location.reload();
}

  // searchSubmit(){
  //   this.allStocksService.getAllStocks();
  //   if(this.allStocksService.Stocks.securityName === ){
  //   // this.searchSecurityName.price = Object.assign({},this.allStocksService.Stocks.close);
  //   console.log(this.allStocksService.Stocks);
  //   console.log(this.searchSecurityName.value.price);
  // }
  // }

  onClick(selected): void{
    this.http.get<any>("http://localhost:8899/api/stocks/all/").subscribe(
      res => { const user = res.find((a:any) => {
        console.log(this.searchSecurityName.value.securityName);
        // console.log(a.securityName);
        
        if(a.symbol == this.searchSecurityName.value.securityName){
          localStorage.getItem(this.portfolioName)

          localStorage.setItem("price",a.price)
          this.searchSecurityName.value.price=a.last
          this.security.price=this.searchSecurityName.value.price
         // this.total=this.searchSecurityName.value.units * this.searchSecurityName.value.price;
          
          console.log(this.searchSecurityName.value.last);
        }
        let investmentValue= localStorage.getItem('InvestmentValue');
        //this.total=this.searchSecurityName.value.units * this.searchSecurityName.value.price;
        //localStorage.setItem("total",this.total);
        //localStorage.setItem("totalTrans",this.security.totalTransaction)
        // if (a.securityName == this.searchSecurityName.value.securityName){
        //   this.searchSecurityName.value.price=a.last;
        //   console.log(this.searchSecurityName.value.price)
        // }
        // else{
        //   localStorage.setItem("price",'Nothing');
        // } 
      })
      
      err => { 
        return alert("There was an error" + err)
      }
    }
    )
  
  }

  // onSelect(selected){

  //    // this.symbol=val;)
    
  //   this.http.get<any>("http://localhost:8899/api/stocks/all").subscribe(
    
  //    res => {
    
  //    const stock = res.find((a:any) => {
    
  //    if(a.securityName == this.searchSecurityName.value.securityName
  //     ){
    
  //   localStorage.setItem("Price",a.last)
    
  //   this.searchSecurityName.value.price = a.last
    
  //   this.security.price = this.searchSecurityName.value.price
    
  //   console.log(this.searchSecurityName.value.price);
    
  //   this.security.currentValue=this.searchSecurityName.value.price*this.searchSecurityName.value.units;
    
  //   this.availableBalance=this.portfolioService.investmentValue-this.security.currentValue;
    
  //   console.log(this.searchSecurityName.value.currentValue);
    
  //   console.log()
    
  //    }
    
  //    })
    
  //    }
    
  //   )
    
    
    
  //    }

  onSave(){
    this.security = {
      securityName: this.searchSecurityName.value.securityName,
      transactionDate: this.searchSecurityName.value.transactionDate,
      units: this.searchSecurityName.value.units,
      price: this.searchSecurityName.value.price,
      totalTransaction: this.searchSecurityName.value.units * this.searchSecurityName.value.price,
      // allocation:this.searchSecurityName.value.allocation
    };
    localStorage.setItem("totalTrans",this.security.totalTransaction);
    let investmentValue=localStorage.getItem("iv");

    localStorage.getItem("totalTrans")

    this.availableBalance=this.portfolio.investmentValue-this.security.totalTransaction;
    localStorage.setItem("avbl",this.availableBalance);
    confirm('Securities Saved')
    console.log(this.security);
    document.write(investmentValue)
    this.securityService.postSecurity(this.security,localStorage.getItem("name")).subscribe({
      next: (data)=>{
        // this.route.navigate(['/securitylist'])
        
      },
      error:(err)=>{
      }
    });

  }
  }
