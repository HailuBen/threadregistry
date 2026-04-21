CREATE TABLE IF NOT EXISTS brands (
    brand_id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    country VARCHAR(255) NOT NULL,
    year_founded VARCHAR(255),
    description VARCHAR(255),
    PRIMARY KEY (brand_id)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    `condition` VARCHAR(255) NOT NULL,
    price FLOAT(53) NOT NULL,
    description VARCHAR(500),
    image_url VARCHAR(255),
    brand_id BIGINT NOT NULL,
    created_at DATETIME(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES brands(brand_id)
);

INSERT INTO brands (name, country, year_founded, description) VALUES
('Nike', 'USA', '1964', 'Global leader in athletic footwear and apparel'),
('Adidas', 'Germany', '1949', 'Performance sportswear and iconic street style'),
('Levi''s', 'USA', '1853', 'The original heritage denim and workwear brand'),
('Acne Studios', 'Sweden', '1996', 'Minimalist Scandinavian luxury and tailoring'),
('Orlebar Brown', 'UK', '2007', 'Premium tailored resort and swim wear'),
('Moncler', 'Italy', '1952', 'Luxury alpine performance and down outerwear'),
('Gucci', 'Italy', '1921', 'Eclectic, contemporary, and romantic Italian luxury'),
('Balenciaga', 'France', '1919', 'Avant-garde silhouettes and luxury streetwear'),
('Stone Island', 'Italy', '1982', 'Innovative fabric research and technical apparel'),
('Saint Laurent', 'France', '1961', 'Modern Parisian elegance and rock-aesthetic');

INSERT INTO products (name, category, gender, `condition`, price, description, brand_id, image_url, created_at) VALUES
('Air Jordan 4 Retro', 'Shoes', 'Men', 'New', 210.00, 'Classic Jordan 4 in Cement Grey', 1, '/images/jordan.png', NOW()),
('Ultraboost 22', 'Shoes', 'Unisex', 'New', 190.00, 'High-performance running technology', 2, '/images/adidas.png', NOW()),
('Nike Air Force 1', 'Shoes', 'Unisex', 'New', 110.00, 'The quintessential white-on-white sneaker', 1, '/images/af1-item2.png', NOW()),
('Adidas Gazelle', 'Shoes', 'Unisex', 'New', 100.00, 'Vintage suede indoor soccer silhouette', 2, '/images/gazelle.png', NOW()),
('Balenciaga Speed Trainer', 'Shoes', 'Unisex', 'Pre-owned', 550.00, 'Iconic sock-style luxury runner', 8, '/images/balenciaga-speed.png', NOW()),
('Moncler Maya Jacket', 'Outerwear', 'Men', 'New', 1250.00, 'Signature glossy down puffer jacket', 6, '/images/moncler-maya.png', NOW()),
('Stone Island Crinkle Reps', 'Outerwear', 'Men', 'New', 840.00, 'Hooded jacket with compass patch', 9, '/images/stone-island-jacket.png', NOW()),
('Levi''s Trucker Jacket', 'Outerwear', 'Unisex', 'New', 98.00, 'Original denim jacket since 1967', 3, '/images/levi-trucker.png', NOW()),
('Saint Laurent Teddy Jacket', 'Outerwear', 'Men', 'Authenticated', 2100.00, 'Classic wool varsity jacket with leather trim', 10, '/images/ysl-teddy.png', NOW()),
('501 Original Jeans', 'Bottoms', 'Men', 'New', 98.00, 'The blueprint for every pair of jeans', 3, '/images/levi.png', NOW()),
('Acne Studios Face T-Shirt', 'Tops', 'Unisex', 'New', 160.00, 'Organic cotton tee', 4, '/images/acne-tee.png', NOW()),
('Orlebar Brown Ridley', 'Tops', 'Men', 'New', 245.00, 'Tailored linen shirt for summer', 5, '/images/ob-shirt.png', NOW()),
('Acne Studios Scarf', 'Accessories', 'Unisex', 'New', 290.00, 'Large multi-check wool scarf', 4, '/images/acne-item3.png', NOW()),
('Gucci Marmont Belt', 'Accessories', 'Unisex', 'New', 490.00, 'Double G leather belt in black', 7, '/images/gucci-belt.png', NOW()),
('Gucci Horsebit Loafers', 'Shoes', 'Men', 'New', 890.00, 'Heritage leather loafers with gold hardware', 7, '/images/gucci-loafers.png', NOW()),
('Saint Laurent Wyatt Boots', 'Shoes', 'Men', 'New', 1150.00, 'Suede Chelsea boots with stacked heel', 10, '/images/ysl-boots.png', NOW());