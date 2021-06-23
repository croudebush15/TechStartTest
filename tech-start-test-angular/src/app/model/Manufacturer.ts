import { deserialize } from "cerialize";

export class Manufacturer{
    @deserialize id: string;
    @deserialize name: string;
    @deserialize address: string;
    @deserialize contact: string;
  
    constructor(id: string, name : string, address : string, contact: string) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
      }
}