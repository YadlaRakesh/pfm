import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Asset } from '../models/Asset.model';
import { Theme } from '../models/Theme.model';
import { SecurityService } from '../services/security.service';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})
export class AssetComponent implements OnInit {

  asset:Asset;
  investmentTheme:string;
  themeDetails : Theme
  themeID : number;
  themeName: string;
  asset1:Asset[];
  

  assetForm = new FormGroup({
    assetId: new FormControl(''),
    assetClass: new FormControl(''),
    subAssetClass: new FormControl(''),
    liquidity: new FormControl(''),
    returns: new FormControl(''),
    InvestmentHorizon: new FormControl(''),
    Risk: new FormControl('')
    // allocation: new FormControl(''),   
    // assetDesc: new FormControl('')
  })
  constructor(private securityService:SecurityService,  private route:Router) { }

  ngOnInit(): void {

    this.assetForm = new FormGroup({
      themeId: new FormControl(''),
      assetId: new FormControl('', [Validators.required,Validators.pattern('[0-9]')]),
      assetClass: new FormControl('', [Validators.required]),
      subAssetClass: new FormControl('', [Validators.required]),
      liquidity: new FormControl('', [Validators.required]),
      returns: new FormControl('', [Validators.required]),
      InvestmentHorizon: new FormControl('', [Validators.required]),
      Risk: new FormControl('', [Validators.required]),
      allocation: new FormControl('', [Validators.required]),
      // assetDesc: new FormControl('', [Validators.required]),
    });

    


    this.securityService.getAssetByThemeName(this.themeName).subscribe({
      next:(data)=>{
        console.log(this.themeName)
        console.log(data);
        this.asset1=data;
        console.log(this.asset);
      }
    })

    this.securityService.getTheme$.subscribe({
      next : (data) => {
        console.log("INSIDE ASSET")
        this.themeDetails = data;
        this.themeID = this.themeDetails.themeId;
        console.log(this.themeID)
      }
    })
  }
  
  // ngAfterContentInit(){
  //   // investmentTheme:any[];
  //   this.investmentTheme = localStorage.getItem("iTheme");
  //   console.log(localStorage.getItem("investmentTheme"))
  // }

  onSubmit(){

    this.asset = {
      assetClass: this.assetForm.value.assetClass,
      assetId: this.assetForm.value.assetId,
      allocation: this.assetForm.value.allocation,
      subAssetClass: this.assetForm.value.subAssetClass,
      liquidity: this.assetForm.value.liquidity,
      returns: this.assetForm.value.returns,
      InvestmentHorizon: this.assetForm.value.InvestmentHorizon,
      risk: this.assetForm.value.Risk,
      // allocation: this.assetForm.value.allocation
      // assetDesc: this.assetForm.value.assetDesc,
    };
    // confirm('Header Submitted')
    console.log(this.asset);

    this.securityService.postAsset(this.asset,this.themeID).subscribe((res:any)=>{
      this.asset=res;
      console.log(this.asset);
        console.log("Redirected")
       
        // console.log(this.route.navigate(['/header']));
        // localStorage.setItem();
    
    
    });
    this.route.navigateByUrl('/head');
}
// onRakesh(){
//   this.route.navigate(['/head']);
// }

}