package com.hcmute.oneforall.utils;

import com.hcmute.oneforall.beans.Account;

public class AccountUtil {
    public static void encodeLogin(Account account){
//        if (account != null) {
//            BCrypt.Result result = BCrypt.verifyer().verify(.toCharArray(), user.getPassword());
//            if (result.verified) {
//                session.setAttribute("auth", true);
//                session.setAttribute("authUser", user);
//
//                ServletUtils.redirect(url, request, response);
//            } else {
//                request.setAttribute("hasError", true);
//                ServletUtils.forward(convertURItoPath(url, request, response), request, response);
//            }
//        } else {
//            request.setAttribute("hasError", true);
//            ServletUtils.forward(convertURItoPath(url, request, response), request, response);
//        }
//    }

//    private static String[] ggLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("gg-name");
//        String image = request.getParameter("gg-image");
//        String email = request.getParameter("gg-email");
//        String password = "1";

//        User user = UserModel.findByEmail(email);
//        if (user == null){
//            int permission = 0;
//            User c = new User(name, email, BCrypt.withDefaults().hashToString(12, "1".toCharArray()), permission, 0);
//            UserModel.ggAdd(c);
//        }

//        return new String[]{email, password};
    }

//    private static String convertURItoPath(String url,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String[] urls = url.split("/");
//        int len = urls.length;
//        if(Objects.equals(urls[4], "Home")){
//            return "/views/vwHome/Index.jsp";
//        }else {
//            if (Objects.equals(urls[4], "Product")){
//                if (len == 7){
//                    if (urls[6].contains("Detail")){
//                        return "/views/vwProduct/ProductDetail.jsp";
//                    }else {
//                        if(urls[6].contains("WithName")){
//                            String proName = request.getParameter("name");
//                            List<Category> cate = CategoryModel.findAll();
//                            List<Product> search = ProductModel.searchPro(proName);
//
//                            request.setAttribute("products", search);
//                            request.setAttribute("categories", cate);
//                        }else{
//                            if (urls[6].contains("ByPrice")){
//                                String proByMoney = request.getParameter("name");
//                                List<Product> byMoney = ProductModel.orderByMoney(proByMoney);
//
//                                request.setAttribute("products", byMoney);
//                            }else {
//                                if (urls[6].contains("ByDate")){
//                                    String proByDate = request.getParameter("name");
//                                    List<Product> byDate = ProductModel.orderByDate(proByDate);
//
//                                    request.setAttribute("products", byDate);
//                                }
//                                else {
//                                    int catId = Integer.parseInt(request.getParameter("id"));
//                                    List<Category> cat = CategoryModel.findAll();
//                                    List<Product> list = ProductModel.findByCatId(catId);
//
//                                    request.setAttribute("products", list);
//                                    request.setAttribute("categories", cat);
//                                }
//                            }
//                        }
//                        return "/views/vwProduct/ProductByCat.jsp";
//                    }
//                }else {
//                    return "/views/vwProduct/Product.jsp";
//                }
//            }
//        }
//        return "/views/404.jsp";
//    }
}
