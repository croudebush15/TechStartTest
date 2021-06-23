import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ItemModel } from '@syncfusion/ej2-angular-splitbuttons';
import { Customer } from '../../model/Customer';
import { Distributor } from '../../model/Distibutor';
import { Invoice } from '../../model/Invoice';
import { Product } from '../../model/Product';
import { InputService } from '../../service/input.service';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit {
  invoiceList: Invoice[];

  fileLoaded: Boolean = false;
  errorLoading: Boolean = false;
  fileForm: FormGroup;
  selectedFile = null; 
  fileToUpload: File;

  constructor(private inputService: InputService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.fileForm = this.formBuilder.group({
      file: ['']
    });  
  }

  onFileSelect(event) {
    if (event.target.files.length > 0) {
      this.selectedFile = event.target.files[0];
    }
  }   

  addFile(): void {
    this.fileToUpload = this.selectedFile;
    if(!this.fileToUpload){
      this.errorLoading = true;
      this.fileLoaded = false;
    }
    else{
      this.inputService.upload(this.fileToUpload).subscribe(
        (res: Invoice[]) => {          
          this.invoiceList = res;      
          this.fileLoaded = true;
          this.errorLoading = false;          
          console.log(res)
        }
      )  
    }    
  }

  
}
