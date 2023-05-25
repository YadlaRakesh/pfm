import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Theme } from '../models/Theme.model';
import { PortfolioheaderService } from '../services/portfolioheader.service';
import { SecurityService } from '../services/security.service';

@Component({
  selector: 'app-itheme',
  templateUrl: './itheme.component.html',
  styleUrls: ['./itheme.component.css']
})
export class IthemeComponent implements OnInit {
  themeForm: any;
  theme:Theme;
  // assetClass:any[];
  assetClass:any;
  constructor(public formgroup:FormBuilder,
    private securityService:SecurityService,
    public http:HttpClient,
    private portfolioService:PortfolioheaderService) { }

  ngOnInit(): void {
    this.assetClass  = [''];
    this.portfolioService.getAsset().subscribe((data:any)=>{
      this.assetClass=data;
      console.log(this.assetClass);
    })
    this.themeForm = this.formgroup.group({ 
      themeName:'',
      assetClass:'',
      risk:'',
      investmentHorizon:''
  });

  }
  onSave(){
    this.theme = {
      themeName: this.themeForm.value.themeName,
      assetClass: this.themeForm.value.assetClass,
      risk: this.themeForm.value.risk,
      investmentHorizon:this.themeForm.value.investmentHorizon
      // : this.searchSecurityName.value.units * this.searchSecurityName.value.price,
      // allocation:this.searchSecurityName.value.allocation
    };
    confirm('Theme Saved')
    console.log(this.theme);

    this.securityService.postTheme(this.theme).subscribe({
      next: (data)=>{
        // this.route.navigate(['/securitylist'])
        console.log(data);
      },
      error:(err)=>{
      }
    });
}
onClick(): void{
  this.http.get<any>("http://localhost:8899/api/get").subscribe(
    res => { const user = res.find((a:any) => {
      console.log(this.themeForm.value.assetClass);
      // console.log(a.securityName);
      if (a.assetClass == this.themeForm.value.assetClass){
        this.themeForm.value.assetClass=a.assetClass;
        console.log(this.themeForm.value.assetClass)
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
}