import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Asset } from '../models/Asset.model';
import { SecurityService } from '../services/security.service';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})
export class AssetComponent implements OnInit {

  asset:Asset;

  assetForm = new FormGroup({
    assetClass: new FormControl(''),
    subAssetClass: new FormControl(''),
    allocation: new FormControl(''),   
    assetDesc: new FormControl('')
  })
  constructor(private securityService:SecurityService,  private route:Router) { }

  ngOnInit(): void {

    this.assetForm = new FormGroup({
      assetClass: new FormControl('', [Validators.required]),
      subAssetClass: new FormControl('', [Validators.required]),
      allocation: new FormControl('', [Validators.required]),
      assetDesc: new FormControl('', [Validators.required]),
    });
  }
  onSubmit(){

    this.asset = {
      assetClass: this.assetForm.value.assetClass,
      subAssetClass: this.assetForm.value.subAssetClass,
      allocation: this.assetForm.value.allocation,
      assetDesc: this.assetForm.value.assetDesc,
    };
    confirm('Header Submitted')
    console.log(this.asset);

    this.securityService.postAsset(this.asset).subscribe({
      next: (data)=>{
        this.route.navigate(['/itheme'])
        // localStorage.setItem();
      },
      error:(err)=>{
      }
    });
}
}