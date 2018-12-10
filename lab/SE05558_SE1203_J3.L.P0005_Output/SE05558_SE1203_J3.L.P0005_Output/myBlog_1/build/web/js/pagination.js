/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var elemIpt = document.getElementById("ipt-current-page");
            var elemPaging = document.getElementById("paging-wrapper");
            var totalPage = document.getElementById("ipt-total-page");
            var currentCategory = document.getElementById("ipt-current-category");
            var PageLo= Number(elemIpt.value);
            
            if (Number(totalPage.value) ===1){
                var i = 0;
                var item=document.createElement("A");
                
                if (PageLo == i+1){
                    item.setAttribute("class","kmli active");
                    item.setAttribute("href","#" );
                }
                else{
                    item.setAttribute("href","category?currentPage=" +(i+1) + "&category=" + currentCategory.value);
                }
                
                item.innerHTML=(i+1);
                elemPaging.appendChild(item);
            }
            else if (Number(totalPage.value) === 2){
                for (var i = 0; i < totalPage.value;++i){
                    var item=document.createElement("A");
                    
                    
                    if (PageLo == i+1){
                            item.setAttribute("class","kmli active");
                            item.setAttribute("href","#");
                    }
                    else{
                        item.setAttribute("href","category?currentPage=" +(i+1)+ "&category=" + currentCategory.value);
                    }
                    item.innerHTML=(i+1);
                    elemPaging.appendChild(item);
                }
            }
            else {
                if (PageLo ===1){
                    for ( var i = 0; i< PageLo +2;++i){
                        var item=document.createElement("A");
                        if (PageLo == i+1){
                            item.setAttribute("class","kmli active");
                            item.setAttribute("href","#");
                        
                        }else{
                            item.setAttribute("href","category?currentPage=" +(i+1)+ "&category=" + currentCategory.value);
                        
                        }
                        item.innerHTML=(i+1);
                        elemPaging.appendChild(item);
                    }
                }
                else if ( PageLo === Number(totalPage.value)){
                    for ( var i = PageLo-3; i< PageLo ;++i){
                        var item=document.createElement("A");
                        if (PageLo == i+1){
                            item.setAttribute("class","kmli active");
                            item.setAttribute("href","#");
                        
                        }
                        else{
                            item.setAttribute("href","category?currentPage=" +(i+1)+ "&category=" + currentCategory.value);
                        
                        }
                        item.innerHTML=(i+1);
                        elemPaging.appendChild(item);
                    }
                }
                else{
                    for ( var i = PageLo-2; i< PageLo +1;++i){
                        var item=document.createElement("A");
                        if (PageLo == i+1){
                            item.setAttribute("class","kmli active");
                            item.setAttribute("href","#");
                        
                        }
                        else{
                            item.setAttribute("href","category?currentPage=" +(i+1)+ "&category=" + currentCategory.value);
                        
                        }
                        item.innerHTML=(i+1);
                        elemPaging.appendChild(item);
                    }
                }
            }