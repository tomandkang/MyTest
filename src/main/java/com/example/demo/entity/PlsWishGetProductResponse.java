package com.example.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Data
public class PlsWishGetProductResponse {


    @JSONField(name = "reference_value")
    private Integer referenceValue;
    @JSONField(name = "updated_at")
    private String updatedAt;
    @JSONField(name = "brand_id")
    private String brandId;
    @JSONField(name = "video")
    private Video video;
    @JSONField(name = "num_sold")
    private Integer numSold;
    @JSONField(name = "id")
    private String id;
    @JSONField(name = "unit")
    private String unit;
    @JSONField(name = "category")
    private String category;
    @JSONField(name = "is_promoted")
    private Boolean isPromoted;
    @JSONField(name = "max_quantity")
    private Integer maxQuantity;
    @JSONField(name = "first_mile_shippings")
    private List<FirstMileShippings> firstMileShippings;
    @JSONField(name = "status")
    private String status;
    @JSONField(name = "default_shipping_prices")
    private List<DefaultShippingPrices> defaultShippingPrices;
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "tags")
    private List<String> tags;
    @JSONField(name = "california_prop65_warning_type")
    private String californiaProp65WarningType;
    @JSONField(name = "num_saves")
    private Integer numSaves;
    @JSONField(name = "extra_images")
    private List<Image> extraImages;
    @JSONField(name = "parent_sku")
    private String parentSku;
    @JSONField(name = "condition")
    private String condition;
    @JSONField(name = "california_prop65_chemical_names")
    private List<String> californiaProp65ChemicalNames;
    @JSONField(name = "main_image")
    private Image mainImage;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "warehouse_to_shippings")
    private List<WarehouseToShippings> warehouseToShippings;
    @JSONField(name = "created_at")
    private String createdAt;
    @JSONField(name = "variations")
    private List<Variations> variations;
    @JSONField(name = "msrp")
    private Msrp msrp;

    @NoArgsConstructor
    @Data
    public static class Video {
        @JSONField(name = "url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class Image {
        @JSONField(name = "url")
        private String url;
        @JSONField(name = "variation_skus")
        private List<String> variationSkus;
        @JSONField(name = "is_clean_image")
        private Boolean isCleanImage;
    }

    @NoArgsConstructor
    @Data
    public static class Msrp {
        @JSONField(name = "amount")
        private BigDecimal amount;
        @JSONField(name = "currency_code")
        private String currencyCode;
    }

    @NoArgsConstructor
    @Data
    public static class FirstMileShippings {
        @JSONField(name = "calculated_first_mile_shipping")
        private CalculatedFirstMileShipping calculatedFirstMileShipping;
        @JSONField(name = "effective_date")
        private String effectiveDate;
        @JSONField(name = "effective_first_mile_shipping")
        private EffectiveFirstMileShipping effectiveFirstMileShipping;
        @JSONField(name = "enabled")
        private Boolean enabled;
        @JSONField(name = "warehouse_id")
        private String warehouseId;

        @NoArgsConstructor
        @Data
        public static class CalculatedFirstMileShipping {
            @JSONField(name = "amount")
            private Double amount;
            @JSONField(name = "currency_code")
            private String currencyCode;
        }

        @NoArgsConstructor
        @Data
        public static class EffectiveFirstMileShipping {
            @JSONField(name = "amount")
            private Double amount;
            @JSONField(name = "currency_code")
            private String currencyCode;
        }
    }

    @NoArgsConstructor
    @Data
    public static class DefaultShippingPrices {
        @JSONField(name = "default_shipping_price")
        private DefaultShippingPrice defaultShippingPrice;
        @JSONField(name = "warehouse_id")
        private String warehouseId;

        @NoArgsConstructor
        @Data
        public static class DefaultShippingPrice {
            @JSONField(name = "amount")
            private BigDecimal amount;
            @JSONField(name = "currency_code")
            private String currencyCode;
        }
    }

    @NoArgsConstructor
    @Data
    public static class WarehouseToShippings {
        @JSONField(name = "shipping_details")
        private List<ShippingDetails> shippingDetails;
        @JSONField(name = "warehouse_id")
        private String warehouseId;

        @NoArgsConstructor
        @Data
        public static class ShippingDetails {
            @JSONField(name = "is_enabled")
            private Boolean isEnabled;
            @JSONField(name = "overrides")
            private List<Overrides> overrides;
            @JSONField(name = "destination")
            private String destination;
            @JSONField(name = "max_delivery_days")
            private Integer maxDeliveryDays;
            @JSONField(name = "price")
            private Price price;

            @NoArgsConstructor
            @Data
            public static class Price {
                @JSONField(name = "amount")
                private BigDecimal amount;
                @JSONField(name = "currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class Overrides {
                @JSONField(name = "is_enabled")
                private Boolean isEnabled;
                @JSONField(name = "price")
                private Price price;
                @JSONField(name = "destination")
                private String destination;
                @JSONField(name = "max_delivery_days")
                private Integer maxDeliveryDays;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class Variations {
        @JSONField(name = "sku")
        private String sku;
        @JSONField(name = "status")
        private String status;
        @JSONField(name = "quantity_value")
        private Integer quantityValue;
        @JSONField(name = "product_id")
        private String productId;
        @JSONField(name = "price")
        private Price price;
        @JSONField(name = "options")
        private List<Options> options;
        @JSONField(name = "cost")
        private Cost cost;
        @JSONField(name = "gtin")
        private String gtin;
        @JSONField(name = "inventories")
        private List<Inventories> inventories;
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "logistics_details")
        private LogisticsDetails logisticsDetails;

        @NoArgsConstructor
        @Data
        public static class Price {
            @JSONField(name = "amount")
            private BigDecimal amount;
            @JSONField(name = "currency_code")
            private String currencyCode;
        }

        @NoArgsConstructor
        @Data
        public static class Cost {
            @JSONField(name = "amount")
            private BigDecimal amount;
            @JSONField(name = "currency_code")
            private String currencyCode;
        }

        @NoArgsConstructor
        @Data
        public static class LogisticsDetails {
            @JSONField(name = "origin_country")
            private String originCountry;
            @JSONField(name = "weight")
            private String weight;
            @JSONField(name = "customs_hs_code")
            private String customsHsCode;
            @JSONField(name = "height")
            private String height;
            @JSONField(name = "width")
            private String width;
            @JSONField(name = "length")
            private String length;
            @JSONField(name = "pieces")
            private Integer pieces;
            @JSONField(name = "declared_name")
            private String declaredName;
            @JSONField(name = "customs_declared_value")
            private CustomsDeclaredValue customsDeclaredValue;
            @JSONField(name = "restricted_flags")
            private List<String> restrictedFlags;
            @JSONField(name = "declared_local_name")
            private String declaredLocalName;

            @NoArgsConstructor
            @Data
            public static class CustomsDeclaredValue {
                @JSONField(name = "amount")
                private Integer amount;
                @JSONField(name = "currency_code")
                private String currencyCode;
            }
        }

        @NoArgsConstructor
        @Data
        public static class Options {
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "value")
            private String value;
        }

        @NoArgsConstructor
        @Data
        public static class Inventories {
            @JSONField(name = "inventory")
            private Integer inventory;
            @JSONField(name = "warehouse_id")
            private String warehouseId;
        }
    }
}
