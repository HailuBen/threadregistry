-- ==========================================================
-- 1. SEED BRANDS (10 Total)
-- ==========================================================
INSERT INTO brands (name, country, year_founded, description) VALUES
('Nike', 'USA', '1964', 'Global leader in athletic footwear and apparel'),           -- 1
('Adidas', 'Germany', '1949', 'Performance sportswear and iconic street style'),      -- 2
('Levi''s', 'USA', '1853', 'The original heritage denim and workwear brand'),         -- 3
('Acne Studios', 'Sweden', '1996', 'Minimalist Scandinavian luxury and tailoring'),    -- 4
('Orlebar Brown', 'UK', '2007', 'Premium tailored resort and swim wear'),             -- 5
('Moncler', 'Italy', '1952', 'Luxury alpine performance and down outerwear'),         -- 6
('Gucci', 'Italy', '1921', 'Eclectic, contemporary, and romantic Italian luxury'),    -- 7
('Balenciaga', 'France', '1919', 'Avant-garde silhouettes and luxury streetwear'),    -- 8
('Stone Island', 'Italy', '1982', 'Innovative fabric research and technical apparel'), -- 9
('Saint Laurent', 'France', '1961', 'Modern Parisian elegance and rock-aesthetic');   -- 10


-- ==========================================================
-- 2. SEED PRODUCTS (20 Total)
-- ==========================================================
INSERT INTO products (name, category, gender, condition, price, description, brand_id, image_url, created_at) VALUES
-- Heritage Sneakers
('Air Jordan 4 Retro', 'Sneakers', 'Men', 'New', 210.00, 'Classic Jordan 4 in Cement Grey', 1, '/images/jordan.png', CURRENT_TIMESTAMP),
('Ultraboost 22', 'Sneakers', 'Unisex', 'New', 190.00, 'High-performance running technology', 2, '/images/adidas.png', CURRENT_TIMESTAMP),
('Nike Air Force 1', 'Sneakers', 'Unisex', 'New', 110.00, 'The quintessential white-on-white sneaker', 1, '/images/af1-item2.png', CURRENT_TIMESTAMP),
('Adidas Gazelle', 'Sneakers', 'Unisex', 'New', 100.00, 'Vintage suede indoor soccer silhouette', 2, '/images/gazelle.png', CURRENT_TIMESTAMP),
('Balenciaga Speed Trainer', 'Sneakers', 'Unisex', 'Pre-owned', 550.00, 'Iconic sock-style luxury runner', 8, '/images/balenciaga-speed.png', CURRENT_TIMESTAMP),

-- Premium Outerwear
('Moncler Maya Jacket', 'Outerwear', 'Men', 'New', 1250.00, 'Signature glossy down puffer jacket', 6, '/images/moncler-maya.png', CURRENT_TIMESTAMP),
('Stone Island Crinkle Reps', 'Outerwear', 'Men', 'New', 840.00, 'Hooded jacket with compass patch', 9, '/images/stone-island-jacket.png', CURRENT_TIMESTAMP),
('Levi''s Trucker Jacket', 'Outerwear', 'Unisex', 'New', 98.00, 'Original denim jacket since 1967', 3, '/images/levi-trucker.png', CURRENT_TIMESTAMP),
('Saint Laurent Teddy Jacket', 'Outerwear', 'Men', 'Authenticated', 2100.00, 'Classic wool varsity jacket with leather trim', 10, '/images/ysl-teddy.png', CURRENT_TIMESTAMP),

-- Tops & Bottoms
('501 Original Jeans', 'Bottoms', 'Men', 'New', 98.00, 'The blueprint for every pair of jeans', 3, '/images/levi.png', CURRENT_TIMESTAMP),
('Acne Studios Face T-Shirt', 'Tops', 'Unisex', 'New', 160.00, 'Organic cotton tee', 4, '/images/acne-tee.png', CURRENT_TIMESTAMP),
('Orlebar Brown Ridley', 'Tops', 'Men', 'New', 245.00, 'Tailored linen shirt for summer', 5, '/images/ob-shirt.png', CURRENT_TIMESTAMP),


-- High-End Accessories
('Acne Studios Scarf', 'Accessories', 'Unisex', 'New', 290.00, 'Large multi-check wool scarf', 4, '/images/acne-item3.png', CURRENT_TIMESTAMP),
('Gucci Marmont Belt', 'Accessories', 'Unisex', 'New', 490.00, 'Double G leather belt in black', 7, '/images/gucci-belt.png', CURRENT_TIMESTAMP),
('Gucci Horsebit Loafers', 'Shoes', 'Men', 'New', 890.00, 'Heritage leather loafers with gold hardware', 7, '/images/gucci-loafers.png', CURRENT_TIMESTAMP),
('Saint Laurent Wyatt Boots', 'Shoes', 'Men', 'New', 1150.00, 'Suede Chelsea boots with stacked heel', 10, '/images/ysl-boots.png', CURRENT_TIMESTAMP);
