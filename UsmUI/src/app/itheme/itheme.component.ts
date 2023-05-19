import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Theme } from '../models/Theme.model';
import { SecurityService } from '../services/security.service';

@Component({
  selector: 'app-itheme',
  templateUrl: './itheme.component.html',
  styleUrls: ['./itheme.component.css']
})
export class IthemeComponent implements OnInit {
  themeForm: any;
  theme:Theme;

  constructor(public formgroup:FormBuilder,
    private securityService:SecurityService,) { }

  ngOnInit(): void {
    this.themeForm = this.formgroup.group({ 
      themeName:'',
      assetClass:'',
      allocation:'',
      risk:'',
      investmentHorizon:''
  });

  }
  onSave(){
    this.theme = {
      themeName: this.themeForm.value.themeName,
      assetClass: this.themeForm.value.assetClass,
      allocation: this.themeForm.value.allocation,
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
}