library("dplyr")
head(mpg)
#Q1 class별 city평균
mpg %>% 
  group_by(class) %>% 
  summarise(city_mean = mean(city))

#Q2 city 평균 높은 순서대로 정렬
mpg %>% 
  group_by(class) %>% 
  summarise(city_mean = mean(city)) %>% 
  arrange(desc(city_mean))

#Q3 highway평균이 높은 회사 3곳
mpg %>% 
  group_by(manufacturer) %>% 
  summarise(highway_mean = mean(highway)) %>% 
  arrange(desc(highway_mean)) %>% 
  head(3)

#Q4 회사별 compact차종 수 내림차순
mpg %>% 
  filter(class=="compact") %>%
  group_by(manufacturer) %>% 
  summarise(compact_count = n()) %>% 
  arrange(desc(compact_count))
