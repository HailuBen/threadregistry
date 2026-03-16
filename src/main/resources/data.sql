-- Seed Brands
INSERT INTO brands (name, country, year_founded, description)
VALUES
('Nike', 'USA', '1964', 'Sportswear and footwear'),
('Adidas', 'Germany', '1949', 'Athletic apparel and shoes'),
('Levi’s', 'USA', '1853', 'Denim and apparel');

-- Seed Products
INSERT INTO products (name, category, gender, description, brand_id, created_at)
VALUES
('Air Jordan 4 Retro', 'Sneakers', 'Men', 'Classic Jordan sneaker', 1, CURRENT_TIMESTAMP),
('Ultraboost 22', 'Sneakers', 'Unisex', 'Comfort running shoe', 2, CURRENT_TIMESTAMP),
('501 Original Jeans', 'Outerwear', 'Men', 'Classic denim jeans', 3, CURRENT_TIMESTAMP);
