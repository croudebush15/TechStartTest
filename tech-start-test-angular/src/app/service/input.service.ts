import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Invoice } from '../model/Invoice';
import { map } from 'rxjs/operators';
import { Distributor } from '../model/Distibutor';
import { Customer } from '../model/Customer';
import { Product } from '../model/Product';
import { Deserialize } from 'cerialize';

@Injectable({
  providedIn: 'root'
})
export class InputService {

  constructor(private http: HttpClient) { }
  invoices: Invoice[];
  distributors: Distributor[];
  customers: Customer[];
  products: Product[];

  upload(fileToUpload: File): Observable<Invoice[]>{
    const url = "http://localhost:8080/import";
    const data: FormData = new FormData();
    data.append('file', fileToUpload);
    return this.http.post(url, data, { observe: 'response' }).pipe(
      map((res) => {   
        if(res.status == 200){       
          this.invoices = Deserialize(res.body, Invoice);                  
          return this.invoices;          
        }                  
      })
    );
  }

  getInvoices(): Observable<Invoice[]>{
    const url = "http://localhost:8080/invoice";
    return this.http.get<Invoice[]>(url).pipe(
      map((res) => {   
        console.log("res: " + res);           
        this.invoices = Deserialize(res, Invoice);        
        return this.invoices;
      })
    );
  } 

  getDistributors(): Observable<Distributor[]>{
    const url = "http://localhost:8080/distributor";
    return this.http.get<Distributor[]>(url).pipe(
      map((res) => {   
        console.log("res: " + res);           
        this.distributors = JSON.parse(JSON.stringify(res));        
        return this.distributors;
      })
    );
  } 

  getCustomers(): Observable<Customer[]>{
    const url = "http://localhost:8080/customer";
    return this.http.get<Customer[]>(url).pipe(
      map((res) => {   
        console.log("res: " + res);           
        this.customers = JSON.parse(JSON.stringify(res));        
        return this.customers;
      })
    );
  } 

  getProducts(): Observable<Product[]>{
    const url = "http://localhost:8080/product";
    return this.http.get<Product[]>(url, { observe: 'response' }).pipe(
      map((res) => {   
        if(res.status == 200){       
          console.log("Products res: " + res.body)
          this.products = Deserialize(res.body, Product);                        
          return this.products;          
        }                  
      })
    );
  } 
}
