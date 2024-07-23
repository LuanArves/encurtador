        package dev.encurtador.encurtador.Links;


        import org.apache.commons.lang3.RandomStringUtils;
        import org.springframework.stereotype.Service;

        import java.time.LocalDateTime;

        @Service
        public class LinkService {

            private LinkRepository linkRepository;

            public LinkService(LinkRepository linkRepository) {
                this.linkRepository = linkRepository;
            }

            //Gerar uma URL aleatoria

            //TODO: REFATORAR PARA INCLUIR PARTE DA URL ORIGINAL NO NOSSO ALGORITIMO DE GERAÇÃO DE URL
            public String gerarUrlAleatoria(){
                return RandomStringUtils.randomAlphabetic(5,10);
            }

            public Links encurtarUrl (String urlOriginal){
                Links link = new Links();
                link.setUrlLonga(urlOriginal);
                link.setUrlEncurtada(gerarUrlAleatoria());
                link.setUrlCreatedAt(LocalDateTime.now());
                link.getUrlQrCode();

                return linkRepository.save(link);
            }

            public Links obterUrlOriginal(String urlEncurtada){

                try{
                    return linkRepository.findByUrlEncurtada(urlEncurtada);
                }catch (Exception e){
                    throw new RuntimeException("Url não existe nos nossos registros", e);
                }
            }

        }
