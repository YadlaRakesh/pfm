import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { stringify } from 'querystring';
import { allstocks } from 'src/models/allstocks';
import { nse } from '../models/Nse';
import { Security } from '../models/Securities.model';


import { AllStocksService } from '../services/all-stocks.service';
import { SecurityService } from '../services/security.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {
  public securityArray: Security[];
  securityName:string;
  // stocksArr1:allstocks[];
  stocksArr1:nse[];
  searchSecurityName: any;
  createPortForm: FormGroup;
  security:Security;
  

  

  constructor(private allStocksService:AllStocksService,
    private securityService:SecurityService,
      public http:HttpClient,
      public formgroup:FormBuilder,
      private route:Router,
      ) { }

  ngOnInit(): void {
      this.searchSecurityName = this.formgroup.group({ 
      securityName:'',
      units:'',
      price:'',
      total:'',
      transactionDate:'',
      getSecurities(){
        this.securityService.getAllSecurities().subscribe(data =>{
          this.securityArray = data;
        })
      }
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

  

  onClick(): void{
    this.http.get<any>("http://localhost:8899/api/stocks/all").subscribe(
      res => { const user = res.find((a:any) => {
        console.log(this.searchSecurityName.value.securityName);
        // console.log(a.securityName);
        if (a.securityName == this.searchSecurityName.value.securityName){
          this.searchSecurityName.value.price=a.close;
          console.log(this.searchSecurityName.value.price)
        }
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

  onSave(){
    this.security = {
      securityName: this.searchSecurityName.value.securityName,
      transactionDate: this.searchSecurityName.value.transactionDate,
      units: this.searchSecurityName.value.units,
      price: this.searchSecurityName.value.price,
      totalTransaction: this.searchSecurityName.value.units * this.searchSecurityName.value.price,
      // allocation:this.searchSecurityName.value.allocation
    };
    confirm('Securities Saved')
    console.log(this.security);

    this.securityService.postSecurity(this.security).subscribe({
      next: (data)=>{
        // this.route.navigate(['/securitylist'])
      },
      error:(err)=>{
      }
    });

  }

  

  }
