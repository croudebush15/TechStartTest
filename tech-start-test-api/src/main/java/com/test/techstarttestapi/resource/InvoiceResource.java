package com.test.techstarttestapi.resource;

import com.test.techstarttestapi.model.*;
import com.test.techstarttestapi.service.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.List;

@RestController
public class InvoiceResource {

    final DistributorService distributorService;
    final InvoiceService invoiceService;
    final CustomerService customerService;
    final ManufacturerService manufacturerService;
    final ProductService productService;
    final InvoiceLineService invoiceLineService;

    public InvoiceResource(DistributorService distributorService, InvoiceService invoiceService, CustomerService customerService, ManufacturerService manufacturerService, ProductService productService, InvoiceLineService invoiceLineService) {
        this.distributorService = distributorService;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.manufacturerService = manufacturerService;
        this.productService = productService;
        this.invoiceLineService = invoiceLineService;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/import")
    public ResponseEntity mapReadExcelDataToDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        invoiceService.removeAll();

        for(int i=1; i<worksheet.getPhysicalNumberOfRows() ;i++) {
            XSSFRow row = worksheet.getRow(i);

            String distributorName = row.getCell(2).getStringCellValue();
            //System.out.println("name: " + distributorName);
            DistributorLocation distributorLocation = distributorService.find(distributorName);
            if (distributorLocation == null){
                distributorLocation = new DistributorLocation();
                distributorLocation.setName(distributorName);
                distributorLocation.setAddress(row.getCell(3).getStringCellValue());
                distributorService.save(distributorLocation);
                //System.out.println("test distributor id: " + distributorLocation.getId());
            }

            String customerName = row.getCell(4).getStringCellValue();
            CustomerLocation customerLocation = customerService.find(customerName);
            if (customerLocation == null){
                customerLocation = new CustomerLocation();
                customerLocation.setName(customerName);
                customerLocation.setAddress(row.getCell(5).getStringCellValue());
                customerService.save(customerLocation);
                //System.out.println("test customer id: " + customerLocation.getId());
            }

            Integer invoiceNum = (int) row.getCell(0).getNumericCellValue();
            Invoice invoice = invoiceService.find(invoiceNum);
            if (invoice == null){
                invoice = new Invoice();
                invoice.setInvoiceNumber(invoiceNum);
                invoice.setPurchaseDate(row.getCell(1).getDateCellValue());
                invoice.setTotalPurchases(1);
                invoice.setDistributorLocation(distributorLocation);
                invoice.setCustomerLocation(customerLocation);
                invoiceService.save(invoice);
            }
            else {
                invoice.addTotalPurchases();
                invoiceService.save(invoice);
            }
            String manufacturerName = row.getCell(6).getStringCellValue();
            Manufacturer manufacturer = manufacturerService.find(manufacturerName);
            if (manufacturer == null){
                manufacturer = new Manufacturer();
                manufacturer.setName(manufacturerName);
                manufacturer.setAddress(row.getCell(7).getStringCellValue());
                manufacturerService.save(manufacturer);
            }
            Integer productCode = (int) row.getCell(8).getNumericCellValue();
            Product product = productService.find(productCode);
            if (product == null){
                product = new Product();
                product.setProductCode(productCode);
                product.setDescription(row.getCell(9).getStringCellValue());
                product.setDistributor(distributorLocation);
                product.setManufacturer(manufacturer);
                productService.save(product);
            }

            InvoiceLine invoiceLine = new InvoiceLine();
            invoiceLine.setUnitOfMeasure(row.getCell(10).getStringCellValue());
            if (invoiceLine.getUnitOfMeasure().equals("CASE")){
                invoiceLine.setQty((int) row.getCell(11).getNumericCellValue());
            }
            invoiceLine.setWeight((int) row.getCell(12).getNumericCellValue());
            invoiceLine.setUnitPrice(row.getCell(13).getNumericCellValue());
            invoiceLine.setProductId(product.getId());
            invoiceLine.setInvoiceId(invoice.getId());
        }

        //returns list of invoices as response by default
        List<Invoice> invoices = invoiceService.getAll();
        if (invoices.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(invoices, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/invoice")
    public ResponseEntity getInvoices(){
        List<Invoice> invoices = invoiceService.getAll();
        if (invoices.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(invoices, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/distributor")
    public ResponseEntity getDistributors(){
        List<DistributorLocation> distributorLocations = distributorService.getAll();
        if (distributorLocations.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(distributorLocations, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/customer")
    public ResponseEntity getCustomers(){
        List<CustomerLocation> customerLocations = customerService.getAll();
        if (customerLocations.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(customerLocations, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/product")
    public ResponseEntity getProducts(){
        List<Product> products = productService.getAll();
        if (products.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }
}
