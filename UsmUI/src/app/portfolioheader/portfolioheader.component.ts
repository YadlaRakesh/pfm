import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Portfolio } from 'src/app/models/Portfolio.model';
import { PortfolioheaderService } from 'src/app/services/portfolioheader.service';

@Component({
  selector: 'app-portfolioheader',
  templateUrl: './portfolioheader.component.html',
  styleUrls: ['./portfolioheader.component.css']
})
export class PortfolioheaderComponent implements OnInit {

  portfolio:Portfolio;
  baseCurrency:string[];
  exchange:string[];
  rebalancingFrequency:string[];
  investmentTheme:string[];
  portfolioType: string[];
  p:string[];
  benchMark:string[];

  createPortForm = new FormGroup({
    portfolioName: new FormControl(''),
    exchange: new FormControl(''),
    rebalancingFrequency: new FormControl(''),
    investAmount: new FormControl(''),   
    portfolioType: new FormControl(''),
    investmentTheme: new FormControl(''),
    baseCurrency: new FormControl(''),
    benchMark: new FormControl(''),
    investmentValue: new FormControl(''),
    currentValue: new FormControl(''),
    returns: new FormControl('')
    // fundamanagerName:new FormControl('')
  })

  constructor(private portfolioService:PortfolioheaderService, private route:Router) { }

  ngOnInit(): void {

    // this.portfolioService.getPortfolio().subscribe(data =>{
    //   this.p=data;
    // })

  

    this.baseCurrency  = ['INR'];
    this.exchange = ['NSE','BSE'];
    this.rebalancingFrequency = ['Monthly','Quaterly','Half Yearly','Yearly'];
    this.investmentTheme = ['Aggresive','Very Aggresive','Moderate Aggresive','Conservative','Moderate Conservative'];
    this.portfolioType = ['Amount','Weightage'];
    this.benchMark = ['Nifty50'];

    this.createPortForm = new FormGroup({
      portfolioName: new FormControl('', [Validators.required]),
      portfolioType: new FormControl('', [Validators.required]),
      benchMark: new FormControl('', [Validators.required]),
      baseCurrency: new FormControl('', [Validators.required]),
      investmentValue: new FormControl('', [Validators.required]),
      investmentTheme: new FormControl('', [Validators.required]),
      exchange: new FormControl('', [Validators.required]),
      rebalancingFrequency: new FormControl('', [Validators.required])
      // fundamanagerName: new FormControl('', [Validators.required])
    });

  }

  onSubmit(){

    this.portfolio = {
      rebalancingFrequency: this.createPortForm.value.rebalancingFrequency,
      baseCurrency: this.createPortForm.value.baseCurrency,
      investmentTheme: this.createPortForm.value.investmentTheme,
      portfolioName: this.createPortForm.value.portfolioName,
      portfolioType: this.createPortForm.value.portfolioType,
      benchMark: this.createPortForm.value.benchMark,
      exchange: this.createPortForm.value.exchange,
      investmentValue: this.createPortForm.value.investmentValue
      // fundamanagerName:this.createPortForm.value.fundamanagerName
    };
    confirm('Header Submitted')
    console.log(this.portfolio);

    this.portfolioService.postPortfolio(this.portfolio).subscribe({
      next: (data)=>{
        this.route.navigate(['/security'])
        console.log(data);
      localStorage.setItem("name",this.portfolio.portfolioName);
      localStorage.setItem("iv",this.portfolio.investmentValue);
            },
      error:(err)=>{
        console.log(err);
      }
    });
  }
}
