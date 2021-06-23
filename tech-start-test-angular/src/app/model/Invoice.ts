import { deserialize, deserializeAs} from "cerialize";
import { Customer } from "./Customer";
import { Distributor } from "./Distibutor";

export class Invoice{
    @deserialize id: string;
    @deserialize invoiceNumber: number;
    @deserialize purchaseDate: Date;
    @deserialize totalPurchases: number;
    @deserializeAs(Customer, 'customerLocation') customerLocation: Customer;
    @deserializeAs(Distributor, 'distributorLocation') distributorLocation: Distributor;

    constructor(id : string, invoiceNumber : number, purchaseDate : Date, totalPurchases: number, customerLocation: Customer, distributorLocation: Distributor) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.purchaseDate = purchaseDate;
        this.totalPurchases = totalPurchases;
        this.customerLocation = customerLocation;
        this.distributorLocation = distributorLocation;
      }
}