package service;

import dao.GoodsDAO;
import entity.Goods;

public class GoodsService {
  private final GoodsDAO goodsDAO = new GoodsDAO();

  public GoodsService() {

  }

  public Goods findGood(Long id) {
    return this.goodsDAO.findById(id);
  }

  public void saveGood(Goods goods) {
    this.goodsDAO.save(goods);
  }

  public void deleteGood(Goods goods) {
    this.goodsDAO.delete(goods);
  }

  public void updateGood(Goods goods) {
    this.goodsDAO.update(goods);
  }
}
