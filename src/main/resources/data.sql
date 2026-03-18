-- Seed Brands
INSERT INTO brands (name, country, year_founded, description) VALUES
('Nike', 'USA', '1964', 'Sportswear and footwear'),
('Adidas', 'Germany', '1949', 'Athletic apparel and shoes'),
('Levi''s', 'USA', '1853', 'Denim and apparel'),
('Acne Studios', 'Sweden', '1996', 'Contemporary luxury');

-- Seed Products
INSERT INTO products (name, category, gender, description, brand_id, image_url, created_at) VALUES
('Air Jordan 4 Retro', 'Sneakers', 'Men', 'Classic Jordan sneaker', 1, '/images/jordan.jpg', CURRENT_TIMESTAMP),
('Ultraboost 22', 'Sneakers', 'Unisex', 'Comfort running shoe', 2, '/images/adidas.png', CURRENT_TIMESTAMP),
('501 Original Jeans', 'Outerwear', 'Men', 'Classic denim jeans', 3, '/images/jeans-item4.jpg', CURRENT_TIMESTAMP),
('Nike Air Force 1', 'Sneakers', 'Unisex', 'Classic Nike sneaker', 1, '/images/af1-item2.png', CURRENT_TIMESTAMP),
('Acne Studios Scarf', 'Accessories', 'Unisex', 'Modern scarf', 4, '/images/acne-item3.jpg', CURRENT_TIMESTAMP);
