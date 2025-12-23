package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository,
                         ProductRepository productRepository,
                         OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap starting...");
        System.out.println("Parts in DB: " + partRepository.count());
        System.out.println("Products in DB: " + productRepository.count());

        if (partRepository.count() == 0 && productRepository.count() == 0) {
            System.out.println("Database empty. Loading sample inventory...");

            loadSampleParts();
            loadSampleProducts();

            System.out.println("Sample inventory loaded.");
        } else {
            System.out.println("Existing inventory detected — skipping sample load.");
        }
    }

        private void loadSampleParts() {

        Set<String> partNames = new HashSet<>();
        List<Part> finalParts = new ArrayList<>();

        Part ram8 = inhousePart("8GB DDR4 RAM", 39.99, 10, 101);
        Part ram16 = inhousePart("16GB DDR4 RAM", 69.99, 8, 102);

        Part nvme = outsourcedPart("500GB NVMe SSD", 59.99, 6, "Storage World");
        Part gpu4060 = outsourcedPart("NVIDIA RTX 4060", 329.99, 3, "GPU Depot");
        Part psu750 = outsourcedPart("750W Power Supply", 99.99, 5, "PowerCo");

        Part duplicateRam8 = inhousePart("8GB DDR4 RAM", 39.99, 10, 101);

        List<Part> sampleParts = List.of(ram8, ram16, nvme, gpu4060, psu750, duplicateRam8);

        for (Part p : sampleParts) {

            if (partNames.contains(p.getName())) {

                p.setName(p.getName() + " (Multi-Pack)");
            }

            partNames.add(p.getName());
            finalParts.add(p);
        }
        finalParts.forEach(partRepository::save);

        System.out.println("Saved parts: " + finalParts);
    }

    private InhousePart inhousePart(String name, double price, int inv, int partId) {
        InhousePart p = new InhousePart();
        p.setName(name);
        p.setPrice(price);
        p.setInv(inv);
        p.setPartId(partId);
        //part g
        p.setMinInv(1);
        p.setMaxInv(200);
        return p;
    }

    private OutsourcedPart outsourcedPart(String name, double price, int inv, String company) {
        OutsourcedPart p = new OutsourcedPart();
        p.setName(name);
        p.setPrice(price);
        p.setInv(inv);
        p.setCompanyName(company);
        //part g
        p.setMinInv(1);
        p.setMaxInv(200);
        return p;
    }
    private void loadSampleProducts() {

        Product office = new Product("Office PC Build", 599.99, 3);
        Product gamingMid = new Product("Mid-Range Gaming PC", 1199.99, 2);
        Product gamingHigh = new Product("High-End Gaming PC", 1799.99, 1);
        Product student = new Product("Student Study PC", 749.99, 4);
        Product creator = new Product("Content Creator Workstation", 1599.99, 2);

        productRepository.save(office);
        productRepository.save(gamingMid);
        productRepository.save(gamingHigh);
        productRepository.save(student);
        productRepository.save(creator);

        System.out.println("Saved sample products.");
    }
}
