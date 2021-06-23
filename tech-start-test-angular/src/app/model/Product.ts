import { deserialize, deserializeAs } from "cerialize";
import { Distributor } from "./Distibutor";
import { Manufacturer } from "./Manufacturer";

export class Product{
    @deserialize id: string;
    @deserialize productCode: number;
    @deserialize description: string;    
    @deserializeAs(Distributor, 'distributor') distributor: Distributor;
    @deserializeAs(Manufacturer, 'manufacturer') manufacturer: Manufacturer;

    constructor(id: string, productCode: number, description : string, manufacturer: Manufacturer, distributor: Distributor) {
        this.id = id;
        this.productCode = productCode;
        this.description = description;
        this.manufacturer = manufacturer;
        this.distributor = distributor;
      }
}