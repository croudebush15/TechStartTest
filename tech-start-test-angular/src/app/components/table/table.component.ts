import { Component, Input, OnInit } from '@angular/core';
import { Customer } from 'src/app/model/Customer';
import { Distributor } from 'src/app/model/Distibutor';
import { Invoice } from 'src/app/model/Invoice';
import { Product } from 'src/app/model/Product';
import { InputService } from 'src/app/service/input.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input() invoiceList: Invoice[];
  
  distributorList: Distributor[];
  customerList: Customer[];
  productList: Product[];
  selected: number = 1;

  constructor(private inputService: InputService) { }

  ngOnInit(): void {
  }

  clickInvoices(): void{
    this.selected = 1;
    this.getInvoices();
  }

  clickCustomers(): void{
    this.selected = 2;
    this.getCustomers();
  }

  clickDistributors(): void{
    this.selected = 3;
    this.getDistributors();
  }

  clickProducts(): void{
    this.selected = 4;
    this.getProducts();
  }

  getInvoices(): void{
    this.inputService.getInvoices().subscribe(
      (res: Invoice[]) => {
        this.invoiceList = res;
        console.log(res)
      }
    )
  }

  getDistributors(): void{
    this.inputService.getDistributors().subscribe(
      (res: Distributor[]) => {
        this.distributorList = res;
        console.log(res)
      }
    )
  }

  getCustomers(): void{
    this.inputService.getCustomers().subscribe(
      (res: Customer[]) => {
        this.customerList = res;
        console.log(res)
      }
    )
  }

  getProducts(): void{
    this.inputService.getProducts().subscribe(
      (res: Product[]) => {
        this.productList = res;
        console.log("Products: " + res)
      }
    )
  }

}
